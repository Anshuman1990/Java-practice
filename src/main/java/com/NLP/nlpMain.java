package com.NLP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.stream.Stream;

import edu.stanford.nlp.coref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.pipeline.StanfordCoreNLPClient;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class nlpMain {
	static String host = "http://localhost";
	public static void main(String[] args) {
//	local();
	callToServer(9000);
	
	}
	
	private static void callToServer(int port)  {
//		String text = "A very, very, very slow-moving, aimless movie about a distressed, drifting young man.";
		String file_name = "D://Dataset//sentiment labelled sentences//imdb_labelled.txt";
		try (Stream<String> stream = Files.lines(Paths.get(file_name))) {

			stream.forEach(new Consumer<String>() {

				@Override
				public void accept(String text) {
					text = text.replaceAll("[0-9]", "");
					System.out.println(text);
					Properties prop = new Properties();
					prop.setProperty("annotators", "pos,sentiment");
					prop.setProperty("outputFormat", "json");
					
					StanfordCoreNLPClient pipeline = new StanfordCoreNLPClient(prop, "http://localhost", port, 2);
					Annotation document = new Annotation(text);
					// run all Annotators on this text
					pipeline.annotate(document);
					
					List<CoreMap> sentences = document.get(SentencesAnnotation.class);
					   for(CoreMap sentence: sentences) {
//						   System.out.println("@@@@@@@@@@@@@"+sentence);
						   System.out.println("Sentiment:- "+sentence.get(SentimentCoreAnnotations.SentimentClass.class));
//						   System.out.println("-----------------POS TAGGER------------");
						   for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
					         String pos = token.get(PartOfSpeechAnnotation.class);
					         System.out.println(token+"############"+pos);
					       }
					     }
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}
	
	private static void local() {
		Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // read some text in the text variable
        String text = "Hi i want to go to assigned queue";

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);
     // these are all the sentences in this document
     // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
     List<CoreMap> sentences = document.get(SentencesAnnotation.class);

     for(CoreMap sentence: sentences) {
       // traversing the words in the current sentence
       // a CoreLabel is a CoreMap with additional token-specific methods
       for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
         // this is the text of the token
         String word = token.get(TextAnnotation.class);
         // this is the POS tag of the token
         String pos = token.get(PartOfSpeechAnnotation.class);
         // this is the NER label of the token
         System.out.println(sentence+"############"+pos);
         String ne = token.get(NamedEntityTagAnnotation.class);
       }

       // this is the parse tree of the current sentence
       Tree tree = sentence.get(TreeAnnotation.class);

       // this is the Stanford dependency graph of the current sentence
       SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
     }

     // This is the coreference link graph
     // Each chain stores a set of mentions that link to each other,
     // along with a method for getting the most representative mention
     // Both sentence and token offsets start at 1!
     Map<Integer, CorefChain> graph = 
       document.get(CorefChainAnnotation.class);
	}
}

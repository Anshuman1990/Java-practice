package com.svm;

import com.apache.poi.Main;
import libsvm.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SVMMain {
    public static void main(String[] args) {
        Main main = new Main();
        List<FeatureExtraction> features = new ArrayList<FeatureExtraction>();
        Map<Double, Double> dataset = main.readExcel("D:\\Dataset\\dh\\Data for LR.xlsx");
        Set<Double> keys = dataset.keySet();
        Iterator itr = keys.iterator();
        while (itr.hasNext()) {
            FeatureExtraction feature = new FeatureExtraction();
            Double key = Double.valueOf(String.valueOf(itr.next()));
            int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            Double value = dataset.get(key);
            double label = 0.0;
            switch (randomNum) {
                case 0:
                    if (value >= 45.0) {
                        label = -1.0;
                    } else {
                        label = 1.0;
                    }
                    break;
                case 1:
                    if (value >= 60.0) {
                        label = -1.0;
                    } else {
                        label = 1.0;
                    }
                    break;
                default:
                    break;
            }
            feature.set_caseId(key);
            feature.set_daysRemaining(value);
            feature.set_classification(randomNum);
            feature.set_label(label);
            features.add(feature);
        }
        svm_node[][] nodes = new svm_node[features.size()][2];
        int index = 0;

        for (int i = 0; i < features.size(); i++) {
            FeatureExtraction feature = features.get(i);
            nodes[i] = SVMMain.buildPoint(feature.get_daysRemaining(), feature.get_label());
        }
        svm_model model = SVMMain.buildModel(nodes, features);
        svm_node inputNode = new svm_node();
        inputNode.index = 1;
        inputNode.value = 20;
        svm_node[] inputNodes = new svm_node[1];
        inputNodes[0] = inputNode;
        System.out.println(SVMMain.predict(model, inputNodes));
    }


    public static svm_node[] buildPoint(double x, double y) {
        svm_node[] point = new svm_node[2];

        // x
        point[0] = new svm_node();
        point[0].index = 1;
        point[0].value = x;

        // y
        point[1] = new svm_node();
        point[1].index = 2;
        point[1].value = y;

        return point;
    }

    public static svm_model buildModel(svm_node[][] nodes, List<FeatureExtraction> features) {
        // Build Parameters
        svm_parameter param = new svm_parameter();
        param.svm_type = svm_parameter.ONE_CLASS;
        param.kernel_type = svm_parameter.RBF;
        param.gamma = 0.802;
        param.nu = 0.1608;
        param.cache_size = 100;

        // Build Problem
        svm_problem problem = new svm_problem();
        problem.x = nodes;
        problem.l = nodes.length;
        problem.y = prepareY(features);

        // Build Model
        return svm.svm_train(problem, param);
    }

    public static double predict(svm_model model, svm_node[] nodes) {
        double[] scores = new double[2];
        double result = svm.svm_predict_values(model, nodes, scores);
        System.out.println("result= " + result);
        return scores[0];
    }

    private static double[] prepareY(List<FeatureExtraction> features) {
        double[] y = new double[features.size()];

        for (int i = 0; i < features.size(); i++)
            y[i] = features.get(i).get_label();

        return y;
    }
}

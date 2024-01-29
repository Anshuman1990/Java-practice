/**
 * 
 */
package com.practice.java8_17.document;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;

/**
 * @author asaha
 *
 */
public class RTFReader extends JFrame{
	public RTFReader() {
		setTitle("RTF File");
		setSize(500, 300);
		setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
	}

	public void read(String path) {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel, BorderLayout.CENTER);

		// Create an RTF editor window
		RTFEditorKit rtfEditor = new RTFEditorKit();
		JEditorPane editor = new JEditorPane();
		editor.setEditorKit(rtfEditor);
		editor.setBackground(Color.white);

		// Add a scroll pane
		JScrollPane scroller = new JScrollPane();
		scroller.getViewport().add(editor);
		topPanel.add(scroller, BorderLayout.CENTER);

		try {
			// Read the rtf File
			FileInputStream fileInputStream = new FileInputStream(new File(path));
			rtfEditor.read(fileInputStream, editor.getDocument(), 0);

			System.out.println(editor.getDocument());
			System.out.println(rtfEditor.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}

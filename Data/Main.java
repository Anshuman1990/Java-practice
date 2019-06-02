package com.logic;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Main {
public static void main(String[] args) {
//	FilePermission perm = new FilePermission("D:\\test.pdf", "read");
//	 AccessController.checkPermission(perm);
	 AccessController.doPrivileged(new PrivilegedAction<Void>() {

		@Override
		public Void run() {
			
			Transferable transfer = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(this);
			DataFlavor flavors[] = transfer.getTransferDataFlavors();
			
			for(int i=0;i<flavors.length;i++){
				DataFlavor flavor = flavors[i];
				Object o;
				try {
					o = transfer.getTransferData(flavor);
					if(o instanceof String){
					String data = (String) o;
					System.out.println(data);
					}
				} catch (UnsupportedFlavorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
//			if(transfer.isDataFlavorSupported(DataFlavor.stringFlavor)){
//					try {
//						Object o = transfer.getTransferData(DataFlavor.stringFlavor);
//						String data = (String) o;
//						System.out.println("-----------------------------------------------------------------------------------------------");
//						System.out.println(data);
//						
//					} catch (UnsupportedFlavorException | IOException e) {
//						e.printStackTrace();
//					}
//			}
			return null;
		}
	});
}
}

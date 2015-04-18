
package IPSanner;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class IPScannerGUI{
	String net_add="";
	String ip="";
	JTextArea incoming;
	BufferedReader macreader;
	JButton button = new JButton("START");
	public static void main(String[] args){
		
		IPScannerGUI hackers = new IPScannerGUI();
		hackers.goHackTheMac();
		 
				
	}
	
	public void goHackTheMac(){
		
		JFrame frame = new JFrame("We own your MAC ");
		JPanel mainpanel = new JPanel();
		incoming = new JTextArea(20,100);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane scroller = new JScrollPane(incoming);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		button.addActionListener(new MacListener());
		mainpanel.add(scroller);
		mainpanel.add(button);
		frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
		frame.setSize(1200, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public class MacListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
		
		try{
			button.setText("Scanning...");	
			button.setEnabled(false);
		    InetAddress myhost=InetAddress.getLocalHost(); 
	        NetworkInterface network = NetworkInterface.getByInetAddress(myhost);
	        byte[] mac = network.getHardwareAddress();
	        incoming.append("My MAC address : ");
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < mac.length; i++) {
	            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
	        }
	        incoming.append(sb.toString()+"\n");
	         ip = myhost.getHostAddress();
	        incoming.append("My IP address : ");
	        incoming.append(ip+"\n\n");
	        int fixed_add = ip.lastIndexOf(".");
	        net_add = ip.substring(0, fixed_add+1);			
		
		incoming.append("Information about other devices on my network\n");
        incoming.append("-------------------------------------------------------------------------\n\n"); 
        
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
           
        }catch(Exception ex){
			ex.printStackTrace();
		}    
	}
	}
	public class IncomingReader implements Runnable {
		public void run(){
	        String new_ip="";

			try{
				for (int j = 1; j < 255; j++) {
		        	
		            new_ip = net_add.concat(String.valueOf(j));
		            if(!new_ip.equals(ip))
		            {
		            	runScanner("ping -l 1 -n 1 -w 50 ", new_ip);   
		            }
		        }//closing for
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			  
	        incoming.append("\n\t\t\tWe Are Anonymous\n"
	        		      + "\t\t\t    We are Hacktivist\n"
	        		      +"\t\t\tWe Represent Freedom\n"
	        		      +"\t\t\t    We oppose Oppression\n"
	        		      +"\t\t\tWhere Liberty is at Risk\n"
	        		      +"\t\t\t    Expect Us.\n\n"
	        		);
			
		}
	}
	
	 public void runScanner(String command1, String address) {

		        String temp = "";
		        try {
		            String operation = command1 +" "+ address;
		            Process pro = Runtime.getRuntime().exec(operation);
		            BufferedReader inputStream = new BufferedReader(
		            new InputStreamReader(pro.getInputStream()));
		            //Process terminal = Runtime.getRuntime().exec("cd C:/Windows/System32");
		            StringBuilder builder = new StringBuilder();
		            for (int i = 0; i < 6; i++) {
		                temp = inputStream.readLine();
		                builder.append(temp);
		            }
		            String text = builder.toString();
		          
		            if(text.contains("TTL")) {
		                incoming.append("IP Address : "+address+"\n");
		        
		            Process pro1 = Runtime.getRuntime().exec("arp -a "+address);
		            BufferedReader inputStream1 = new BufferedReader(
		            new InputStreamReader(pro1.getInputStream()));
		            //Process terminal = Runtime.getRuntime().exec("cd C:/Windows/System32");
		            StringBuilder builder1 = new StringBuilder();
		            for (int i = 0; i < 4; i++) {
		                temp = inputStream1.readLine();
		                builder1.append(temp);
		            }
		            
		            String text1 = builder1.toString();
		            //System.out.println(text1);
		           incoming.append("MAC Address :"+text1.substring(105,123).toUpperCase());
		           incoming.append("\n\n");
		          }
		        //else {System.out.println(address + " : Not Connected");}

		        } catch (IOException e) {
		           incoming.append("Error.....Exiting Gracefully.");
		        }
		    }//closing RunScanner class
	 
}	//closing IPScannerGUI class
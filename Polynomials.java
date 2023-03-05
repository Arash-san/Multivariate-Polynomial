import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Node {
	double coef;
    int expx, expy, expz, expk;
    Node link;
    Node(double coef, int expx, int expy, int expz,int expk, Node link) {
        this.coef = coef;
        this.expx = expx;
        this.expy = expy;
        this.expz = expz;
        this.expk = expk;
        this.link = link;
    }
    Node() {
    	this(0,0,0,0,0,null);
    }
    Node getNext() {
    	return link;
    }
    void setNext(Node n) {
    	link = n;
    }
}
class UserInterface extends JFrame {
	static int action=0;
	static String txt1 = "";
	static String txt2 = "";
	int backup_counter=0;
	JPanel jp = new JPanel();
	JPanel scroll_p = new JPanel();
	JLabel label1 = new JLabel("Select one of the options to perform it on the polynomial(s):");
	JLabel wow = new JLabel("Oh hi :)");
	JPanel[] rec1;
	JPanel[] pn1;
	JPanel[] pn2;
	JLabel[][] lab ;
	JLabel[] arrow ;
	ButtonGroup group = new ButtonGroup();
	JTextField tf1= new JTextField();
	JTextField tf2= new JTextField();
//	JScrollPane sp = new JScrollPane(scroll_p);
	JButton btn = new JButton("Calculate");
	UserInterface() {
		super("Polynomial");
		JRadioButton r1 = new JRadioButton("Convert");
		JRadioButton r2 = new JRadioButton("Add");
		JRadioButton r3 = new JRadioButton("Multiply");

		tf2.setVisible(false);
	    r1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            action=0;
	            tf2.setVisible(false);
	        }
	    });
	    r2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	 action=1;
	        	 tf2.setVisible(true);
	        }
	    });
	    r3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	 action=2;
	        	 tf2.setVisible(true);
	        }
	    });
	    btn.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	txt1 = Project.polish(tf1.getText());
	    	
	    	if (action ==0 ) {
	    		Project.doingConvert(); 
	    	}
	    	if (action ==1 ) {
	    		txt2 = Project.polish(tf2.getText());
	            while(Project.first!=null) {
	            	Project.deleteFirst(1);
	            }
	            while(Project.first2!=null) {
	            	Project.deleteFirst(2);
	            }
	            while(Project.first3!=null) {
	            	Project.deleteFirst(3);
	            }	
	        	Project.convert(UserInterface.txt1,0,0,0,0,false);
	        	Project.convert(UserInterface.txt2,0,0,0,0,true);
	    		Project.add(Project.first,Project.first2); 
	    	}
	    	if (action ==2 ) {
	    		txt2 = Project.polish(tf2.getText());
	            while(Project.first!=null) {
	            	Project.deleteFirst(1);
	            }
	            while(Project.first2!=null) {
	            	Project.deleteFirst(2);
	            }
	            while(Project.first3!=null) {
	            	Project.deleteFirst(3);
	            }	
	            while(Project.first4!=null) {
	            	Project.deleteFirst(4);
	            }	
	        	Project.convert(UserInterface.txt1,0,0,0,0,false);
	        	Project.convert(UserInterface.txt2,0,0,0,0,true);
	    		Project.multiply(Project.first,Project.first2); 
	    	}
//	    	removeAll();
	    	int x=20, y=20, width = 160, height = 60, counter=0, counter2=0,i=0,j=0;
			Node temp1, temp2;
			if (action==0) {
				temp1 = Project.first;
				temp2 = Project.first;
			}
			else if (action==1) {
				temp1 = Project.first3;
				temp2 = Project.first3;
			}
			else {
				temp1 = Project.first4;
				temp2 = Project.first4;
			}
			while(temp1!=null) {
				counter++;
				temp1=temp1.getNext();
			}
			scroll_p.removeAll();
			System.out.println("counter = "+counter);
			while (temp2!=null) {
			JPanel[] rec1 = new JPanel[counter];
			JPanel[] pn1 = new JPanel[counter];
			JPanel[] pn2 = new JPanel[counter];
			JLabel[][] lab = new JLabel[counter][6];
			JLabel[] arrow = new JLabel[counter];
	    	rec1[j] = new JPanel(new GridLayout(2,1,2,2));
	    	pn1[j] = new JPanel(new GridLayout(1,4));
	    	pn2[j] = new JPanel(new GridLayout(1,2));
	    	lab[j][0] = new JLabel("x^"+temp2.expx,SwingConstants.CENTER);
	    	lab[j][1] = new JLabel("y^"+temp2.expy,SwingConstants.CENTER);
	    	lab[j][2] = new JLabel("z^"+temp2.expz,SwingConstants.CENTER);
	    	lab[j][3] = new JLabel("k^"+temp2.expk,SwingConstants.CENTER);
	    	lab[j][4] = new JLabel("coef: "+temp2.coef,SwingConstants.CENTER);
	    	lab[j][5] = new JLabel("\u2022",SwingConstants.CENTER);
	    	arrow[j] = new JLabel("----->",SwingConstants.CENTER);
	    	for (int z=0; z<6; z++) {
	    		lab[j][z].setForeground(Color.white);
	    	}
	    	arrow[j].setForeground(Color.black);
	    	lab[j][5].setFont(new Font("Arial", Font.PLAIN, 40));
	    	arrow[j].setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    	rec1[j].add(pn1[j]); rec1[j].add(pn2[j]);
			rec1[j].setBackground(new Color(200, 200, 200));
			pn1[j].setBackground(new Color(150, 150, 150));
			pn2[j].setBackground(new Color(150, 150, 150));
			rec1[j].setBounds(x,y,width,height);
			arrow[j].setBounds(x+width-10,y+26,100,30);
			pn1[j].add(lab[j][0]); pn1[j].add(lab[j][1]); pn1[j].add(lab[j][2]); pn1[j].add(lab[j][3]);
	    	pn2[j].add(lab[j][4]); pn2[j].add(lab[j][5]);
	    	repaint();
			scroll_p.add(rec1[j]);
			if (j<counter-1)
				scroll_p.add(arrow[j]);
			x+=width+100;
			
			j++;
			temp2 = temp2.getNext();
			if (j%4==0) {
				x=20;
				y+=80;
			}
			backup_counter = counter;
			}
			repaint();
			revalidate();
	      }
	    });
	    r1.setSelected(true);
		group.add(r1);  group.add(r2);   group.add(r3);
		jp.add(r1);  jp.add(r2);  jp.add(r3); jp.add(label1); jp.add(tf1); jp.add(tf2); jp.add(btn);
		jp.add(scroll_p);
		jp.setLayout(null);
		scroll_p.setLayout(null);
		scroll_p.setBounds(10,70,1245, 702);
		label1.setBounds(10,10,400, 20);
		r1.setBounds(10,40,80, 20); r2.setBounds(90,40,60, 20); r3.setBounds(150,40,80, 20);
		tf1.setBounds(400,10,500, 20);
		tf2.setBounds(400,40,500, 20);
		btn.setBounds(240,40,110, 20);
		jp.add(scroll_p);
		getContentPane().add(jp);
		setSize(1100, 800);
		setLocation(90, 90);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    setVisible(true);
	}
}
public class Polynomials {
	static int length = 0;
	static int length2 = 0;
	static int length3 = 0;
	static int length4 = 0;
	static Node first = null;
	static Node first2 = null;
	static Node first3 = null;
	static Node first4 = null;
	static Node recReverse(Node p){
		if(p==null || p.getNext()==null) return p;
		Node q=p.getNext();
		Node r=recReverse(q);
		q.setNext(p);
		p.setNext(null);
		return r;
	}
    public static String toStr(char a) {
    	String temp = "";
        StringBuilder sb = new StringBuilder(temp);
        sb.append(a);
        return sb.toString();
    }
    public static Boolean isAdad(String str) {
    	try {
    		Double.parseDouble(str);
    	}
    	catch(Exception NumberFormatException) {
    		return false;
    	}
    	return true;
    }
    public static void convert(String exp, int expx, int expy, int expz, int expk, boolean status) {
    	exp = exp + toStr('+');
        String temp="",jodasazi1="";
        char var;
        int j=0, k=0, max=0, tedad=0, tedad2=0, startPoint=0;
        for(int i=0; i<exp.length(); i++) {
            if(exp.charAt(i) == '(') {
                tedad++;
                max++;
            }
            if (exp.charAt(i) == ')') tedad--;
            if (exp.charAt(i) == '+' && tedad == 0 && max!=0) {
            	temp = "";
            	if (j==0) j=1;          	
                for(j=i-1; exp.charAt(j) !='^' && j>0; j--) {
                    temp=toStr(exp.charAt(j))+ temp;
                }

//                System.out.println("tavan ==  "+temp);
                var = exp.charAt(j-1);
//                System.out.println("var = "+var);
                for(k=i-1; k>=0 ; k--) {
                    if(exp.charAt(k) == ')') tedad2++; 
                    if(exp.charAt(k) == '(') tedad2--;
                    if(tedad2 == 0 && exp.charAt(k) == '+') {
                    	startPoint = k;
                    	break;
                    }
                }
                k++;
                jodasazi1 = exp.substring(k+1, j-2);
//                System.out.println("zarib==  "+jodasazi1);
                if (isAdad(jodasazi1)) {
                	if (var == 'x') expx = Integer.parseInt(temp);
                	if (var == 'y') expy = Integer.parseInt(temp);
                	if (var == 'z') expz = Integer.parseInt(temp);
                	if (var == 'k') expk = Integer.parseInt(temp);
//                	System.out.println("=========="+jodasazi1+"x^"+expx+"y^"+expy+"z^"+expz);
                	if (status == false) {
                		first = new Node(Double.parseDouble(jodasazi1),expx,expy,expz,expk,first);
                		length++;
                	}
                	if (status == true) {
                		first2 = new Node(Double.parseDouble(jodasazi1),expx,expy,expz,expk,first2);
                		length2++;
                	}
                }
//                System.out.println("------------------------");
                if (var == 'k') convert(jodasazi1,expx, expy, expz ,Integer.parseInt(temp),status);
                if (var == 'z') convert(jodasazi1,expx, expy, Integer.parseInt(temp),expk,status);
                if (var == 'y') convert(jodasazi1,expx, Integer.parseInt(temp), expz,expk,status);
                if (var == 'x') convert(jodasazi1,Integer.parseInt(temp), expy, expz,expk,status);

            }
        }
    }
	static boolean isEmpty(int n){
		if (n==1) return length==0;
		if (n==2) return length2==0;
		if (n==3) return length3==0;
		else return length4==0;
		
	}
	static void deleteFirst(int n){
		if (n==1) {
			if(isEmpty(1))
				System.out.println("ERROR! "+n+"\n");
			else{
				first=first.getNext();
				length--;
			}
		}
		if (n==2) {
			if(isEmpty(2))
				System.out.println("ERROR! "+n+"\n");
			else{
				first2=first2.getNext();
				length2--;
			}
		}
		if (n==3) {
			if(isEmpty(3))
				System.out.println("ERROR! "+n+"\n");
			else{
				first3=first3.getNext();
				length3--;
			}
		}
		if (n==4) {
			if(isEmpty(4))
				System.out.println("ERROR! "+n+"\n");
			else{
				first4=first4.getNext();
				length4--;
			}
		}
	}
    public static void traverse(Node f) {
    	String output="";
//    		f=recReverse(f);
            while(f!=null) {
            	output+= f.coef;
            	output+= (f.expx != 0) ? "x^"+f.expx : "";
            	output+= (f.expy != 0) ? "y^"+f.expy : "";
            	output+= (f.expz != 0) ? "z^"+f.expz : "";
            	output+= (f.expk != 0) ? "k^"+f.expk : "";
            	output+=" --> ";
            	f = f.getNext();
            }
            try {
            	output = output.substring(0,output.length()-5);
            }
            catch(Exception e) {}
        System.out.println(output);
    }
    public static void multiply(Node a, Node b) {
    	Node a_back; Node b_back;
    	int j=0,s=0,i=0,w=0;
    	traverse(a);
    	System.out.println("-----------------------------");
    	traverse(b);
    	System.out.println("-----------------------------");
    	System.out.println("length == "+length+" length2 == "+length2);
    	Node temp = b;
    	while(a!=null) {
    		j=0;
    		while(b!=null) {
    			first3 = new Node(a.coef*b.coef,a.expx+b.expx,a.expy+b.expy,a.expz+b.expz,a.expk+b.expk,first3);
    			length3++;
    			j++;
    			b = b.getNext();
    		}
    		s++;
    		b = temp;
    		a = a.getNext();
    	}	
    	traverse(first3);
    	boolean[] kh1 = new boolean[length3];
    	boolean[] kh2 = new boolean[length3];
    	System.out.println("length3 == "+length3);
    	System.out.println("----------------------------");
    	Node temp1 = first3;
    	Node temp2 = first3;
    	a_back = first3;
    	s=0; j=0;
    	Node tem = temp2;
    	while(temp1!=null) {
    		j=0;
    		while(temp2!=null) {
    			if (temp2.expx == temp1.expx && temp2.expy == temp1.expy && temp2.expz == temp1.expz && temp2.expk == temp1.expk && s!=j && kh1[j]==false) {
    				first4 = new Node(temp2.coef+temp1.coef,temp2.expx,temp2.expy,temp2.expz,temp2.expk,first4);
//    				System.out.println("yaaaaaaaaaaaaaaaaaaaay!");
    				length4++;
    				kh1[j] = true; kh1[s] = true;
    			}
    			j++;
    			temp2 = temp2.getNext();
    		}
    		s++;
    		temp2 = tem;
    		temp1 = temp1.getNext();
    	}
    	i=0;
    	while(a_back!=null) {
    		if(kh1[i]==false) {
				first4 = new Node(a_back.coef,a_back.expx,a_back.expy,a_back.expz,a_back.expk,first4);
				length4++;
    		}
    		a_back = a_back.getNext();
    		i++;
    	}
    	traverse(first4);
    	System.out.println("length4 == "+length4);
    }
    public static void add(Node a, Node b) {
    	Node a_back = a; Node b_back = b;   	
    	int j = 0, i=0, w=0, s=0;
    	String output = "";
    	traverse(a);
    	System.out.println("-----------------------------");
    	traverse(b);
    	System.out.println("-----------------------------");
    	boolean[] kh1 = new boolean[length+1];
    	boolean[] kh2 = new boolean[length2+1];
    	System.out.println("length == "+length+" length2 == "+length2);
//    	System.out.println("a.coef ==>>>>>> "+a.coef+"b.coef ==>>>>>>> "+b.coef);
    	Node temp = b;
    	while(a!=null) {
    		j=0;
    		while(b!=null) {
    			if (a.expx == b.expx && a.expy == b.expy && a.expz == b.expz && a.expk == b.expk) {
    				first3 = new Node(a.coef+b.coef,a.expx,a.expy,a.expz,a.expk,first3);
//    				System.out.println("yaaaaaaaaaaaaaaaaaaaay!");
    				length3++;
    				kh2[j] = true; kh1[s] = true;
    			}
    			j++;
    			b = b.getNext();
    		}
    		s++;
    		b = temp;
    		a = a.getNext();
    	}
    	while(a_back!=null) {
    		if(kh1[i]==false) {
				first3 = new Node(a_back.coef,a_back.expx,a_back.expy,a_back.expz,a_back.expk,first3);
				length3++;
    		}
    		a_back = a_back.getNext();
    		i++;
    	}
    	while(b_back!=null) {
    		if(kh2[w]==false) {
				first3 = new Node(b_back.coef,b_back.expx,b_back.expy,b_back.expz,b_back.expk,first3);
				length3++;
    		}
    		b_back = b_back.getNext();
    		w++;
    	}
    	traverse(first3);
    	System.out.println("length3 == "+length3);
    }
    public static void doingConvert() {
    	while(first!=null) {
        	deleteFirst(1);
        }
        String exp = UserInterface.txt1;
        exp = exp.replaceAll(" ","");
        String output="";
        convert(exp,0,0,0,0,false);
        traverse(first);
        
    }
    public static String polish(String str) {
    	str.toLowerCase();
    	StringBuilder str2 = new StringBuilder(str);
    	String[] ch = {"x","y","z","k"};
    	for (int i=0; i<ch.length; i++) {
    		str = str.replace(ch[i]+")",ch[i]+"^1)");
    		str = str.replace(ch[i]+"+",ch[i]+"^1+");
    		str = str.replace(ch[i]+"-",ch[i]+"^1-");
    	}
    	for (int i=0; i<ch.length; i++) {
    		if (str.charAt(str.length()-1) == ch[i].charAt(0)) {
    			str += "^1";
    		}
    	}
    	str = str.replace(")+", ")k^0+");
    	if (str.charAt(str.length()-1) == ')') {
    		str+="k^0";
    	}
//    	System.out.println(str);
    	return str;
    }
    public static void main(String[] args) {
    	new UserInterface();
    	Scanner input = new Scanner(System.in);
    	String aa = input.nextLine();
    	polish(aa);
    }
}

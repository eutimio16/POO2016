package poo2ParcialenAdela;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;


public class Numerote {

	private byte[] numerote;
	private boolean signo;

	public Numerote(){
		this("0");
	}

	public Numerote(String a){
		this.numerote=this.stringToByteArray(a);
	}

	private byte[] stringToByteArray(String a){
		byte[] nuevo;
		if(a.charAt(0)== '-'){//
			signo=false;
			a=a.substring(1);
		}else{
			signo=true;
		}

		String[] guardnum=a.split("");
		nuevo= new byte[guardnum.length];

		for(int i=0;i<guardnum.length;i++){
			nuevo[i]=Byte.parseByte(guardnum[guardnum.length - (i+1)]);
		}
		return nuevo;
	}

	private Numerote sumaabs(Numerote a){
		byte carry=0, sumapa=0;
		byte[] b,c;
		String resultado="";
		if(a.toString().length()>this.toString().length()){
			b=this.stringToByteArray(a.toString());
			c=this.numerote;
		}else{
			b=this.numerote;
			c=this.stringToByteArray(a.toString());
		}
		for(int i=0;i<b.length;i++){
			byte carrya=carry;
			if(i+1<=c.length){
				sumapa=(byte)(b[i]+c[i]+carry);
			} else {
				sumapa=(byte)(b[i]+carry);
			}
			if(sumapa>9){
				//carry siempre es 1
				carry=1;//Byte.parseByte((sumap+"").substring(0, 1));
				sumapa=(byte)(sumapa-10);//Byte.parseByte((sumap+"").substring(1,2));
				//sumap no puede ser mayor a 8 porque 9+9 es igual a 18
				//sumap=(byte)(sumap+carrya);
			}else{
				carry=0;
			}
			resultado=(sumapa+"")+resultado;
		}
		if(carry>0){
			resultado=(carry+"")+resultado;
		}
		return new Numerote(resultado);
	}

	public Numerote suma(Numerote a){
		if((a.signo==true) && (this.signo==true)){	
			return this.sumaabs(a);
		}else if((a.signo==false)&&(this.signo==false)){
			Numerote x= new Numerote("-"+this.sumaabs(a));
			return x;
		}else if((a.signo==true) && (this.signo==false)){
			return this.resta(a);
		}else{
			return a.sumaabs(this);
		}
	}

	private Numerote restaabs(Numerote a){
		byte restapa=0;
		byte[] mayor,menor;
		String signoresultado="";
		String resultado="";
	
		if(a.numerote.length>this.numerote.length){
			mayor=a.numerote;
			menor=this.numerote;
			signoresultado="-";
		}else if(a.numerote.length<this.numerote.length){
			mayor=this.numerote;
			menor=a.numerote;
		}else{
			for(int i=a.numerote.length-1;i>=0;i--){
				if(a.numerote[i]>this.numerote[i]){
					mayor=a.numerote;
					menor=this.numerote;
				}else if(a.numerote[i]<this.numerote[i]){
					mayor=this.numerote;
					menor=a.numerote;
					signoresultado="-";
				}
			}
			return new Numerote();
		}
		int ultimo = menor.length;
		for(int i = 0; i<menor.length; i++){
			if(mayor[i]<menor[i]){
				mayor[i] += 10;
				int temp = i + 1;
				while(mayor[temp] == 0){
					mayor[temp] += 9;
					temp++;
				}
				mayor[temp]--;
			}
			restapa=(byte)(mayor[i]-menor[i]);
			if(resultado.charAt(0)=='0'){
				resultado.substring(0);
				resultado=(restapa+"")+(resultado+"");
			}
			else{
				resultado=(restapa+"")+(resultado+"");
			}
			
		}
		while(ultimo < mayor.length){
			resultado = mayor[ultimo]+resultado;
			ultimo++;
		}
			if(signoresultado.equals("-")){
				resultado=(signoresultado+"")+resultado;
			}
		
		return new Numerote(resultado);
	}

	public Numerote resta(Numerote a){
		if((a.signo==true) && (this.signo==false)){
			return this.sumaabs(a);
		}else if((a.signo==false) && (this.signo==true)){
			return this.sumaabs(a);
		}else if((a.signo==false) && (this.signo==false)){
			return a.restaabs(this);
		}else{
			return this.restaabs(a);
		}
	}
	public Numerote multiplicacion(Numerote a){
		Numerote result=new Numerote();
		result.numerote=new byte[this.numerote.length+a.numerote.length];
		for (int i=0; i<result.numerote.length;i++){
			result.numerote[i]=(byte)0;
		}
		for(int i=0;i<this.numerote.length;i++){
			for(int j=0;j<a.numerote.length;j++){
				result.numerote[i+j]+=a.numerote[j]*this.numerote[i];
				result.numerote[i+j]%=10;
				result.numerote[i+j+1]+=result.numerote[i+j]/10;
			}
		}
		return result;
	}
	/*public Numerote multiplicacion(Numerote a){
		Numerote result=new Numerote();
		result.numerote=new byte[this.numerote.length+a.numerote.length];
		for (int i=0; i<result.numerote.length;i++){
			result.numerote[i]=(byte)0;
		}
		for(int i=0;i<this.numerote.length;i++){
			for(int j=0;j<a.numerote.length;j++){
				result.numerote[i+j]+=a.numerote[j]*this.numerote[i];
				result.numerote[i+j]%=10;
				result.numerote[i+j+1]+=result.numerote[i+j]/10;
			}
		}
		return result;
	}*/

	public String toString(){
		String x=new String(numerote);
		String y=new String();
		if(signo==false){
			y=y.concat("-");
		}
		for(int i=x.length()-1;i>=0;i--){
			y+=numerote[i]+"";
		}
		return y;
	}

	public static void ejecutaArchivo(String entrada, String salida){

		try{
			BufferedReader ent= new BufferedReader(new FileReader(entrada));
			PrintWriter sal= new PrintWriter(new FileWriter(salida));
			String linea;
			StringTokenizer st;
			while((linea = ent.readLine())!=null){	
				st=new StringTokenizer(linea, ",");
				String op1=st.nextToken();
				String op2=st.nextToken();
				String tipoop=st.nextToken();

				Numerote a=new Numerote(op1);
				Numerote b=new Numerote(op2);

				switch(tipoop){
				case "s": sal.println(a.suma(b));
				break;
				case "r": sal.println(a.resta(b));
				break;
				case "m": sal.println(a.multiplicacion(b));
				break;
				default: sal.println("Operación inválida");
				}
			}

			ent.close();
			sal.close();
		}catch(FileNotFoundException e){
			System.out.println("No se encontro sus archivo");		
		}catch(IOException e){
			System.out.println("No se pudo accesar a su archivo");
		}

		finally{
			System.out.println("Fin del programa");
		}
	}


	public static void main(String[] args){
		Numerote a= new Numerote("50");
		Numerote b= new Numerote("25");
		Numerote z= a.resta(b);
		System.out.println(z.toString());
		
		
		try{
			Numerote x = new Numerote();

			x.ejecutaArchivo("Entrada.txt", "Salida.txt");

		}
		catch(StringIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null,"Captura numeros");
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Solo ingrese numeros");
		}

	}
}
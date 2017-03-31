
public class Pila <T> {
	private T[] pila;	
	
	public Pila(){
		pila=(T[])new Object[9];
	}
	
	public void push(T dato){
		for(int i=0; i<pila.length;i++){
			if(pila[i]==null){
				pila[i]=dato;
			}
		}
		
		
	}
	public T pop(){
		T a=null;
		for(int i=pila.length; i>=0; i--){
			if(pila[i]!=null){
				a=pila[i];
				pila[i]=null;
			}
		}
	
		return a;
	
	}
	
	public int size(){
		int contador=0;
		for(int i=0; i<pila.length;i++){
			if(pila[i]!=null){
			 contador++;
			}
		}
		return contador;
		
	}
	
	public String toString(){
		String pilaString="";
		for(int i=0; i<pila.length;i++){
			if(pila[i]!=null){
				System.out.println(pila[i] + ", ");
			 //pilaString += pila[i]+ ", ";
			}
		}
		
		return pilaString;

	}



	
	public static void main(String[] args) {
		Pila <Integer> prueba= new Pila<Integer>();
			prueba.push(1);
			prueba.push(2);
			prueba.push(3);
			prueba.push(4);
			prueba.push(5);
			prueba.push(6);
			prueba.push(7);
			prueba.push(8);
			prueba.push(9);

			
			prueba.toString();
			
			
		
	}

}

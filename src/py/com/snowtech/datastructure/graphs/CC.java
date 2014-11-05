package py.com.snowtech.datastructure.graphs;

//preprocesar el grafo para responder consultas
//es v conectado a w en tiempo constante
public class CC {
	private int count;
	
    //encontrar componentes conectados en 'g'
	public CC(Grafo g) {
		this.count = 0;
	}
	
	//esta v conectado a w ?
	public boolean connected(int v, int w) {
		return false;
	}
	
	//numero de componentes conectados;
	int count() {
		return this.count;
	}
	
	//componente identificador para v
	int id(int v) {
		return -1;
	}

}

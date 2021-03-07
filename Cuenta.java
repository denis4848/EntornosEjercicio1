import java.util.Vector;

public class Cuenta
{
	protected String numero;
	protected String titular;
	protected Vector movimientos;
	public Cuenta(String _numero, String _titular)
	{
		numero=_numero;
		titular=_titular;
		movimientos=new Vector();
	}
	public void ingresar(double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m=new Movimiento();
		m.setConcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.movimientos.addElement(m);
	}
	public void retirar(double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto("Retirada de efectivo");
		m.setImporte(-x);
		this.movimientos.addElement(m);
	}
	public void ingresar(String concepto, double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(x);
		this.movimientos.addElement(m);
	}
	public void retirar(String concepto, double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.movimientos.addElement(m);
	}
	public double getSaldo()
	{
		double r=0.0;
		for (int i=0; i<this.movimientos.size(); i++)
		{
			Movimiento m=(Movimiento) movimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}
	public void addMovimiento(Movimiento m)
	{
		movimientos.addElement(m);
	}
}
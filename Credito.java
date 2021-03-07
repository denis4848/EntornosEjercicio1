
import java.util.Vector;
import java.util.Date;

/**
 * @author Denis Guimpu
 * The type Credito.
 */
public class Credito extends Tarjeta
{


	/**
	 * The Credito.
	 */
	protected double credito;
	/**
	 * The Movimientos.
	 */
	protected Vector movimientos;

	/**
	 * Instantiates a new Credito.
	 *
	 *
	 * @param _numero         the numero
	 * @param _titular        the titular
	 * @param _fechaCaducidad the fecha caducidad
	 * @param _credito        the credito
	 */
	public Credito(String _numero, String _titular, Date _fechaCaducidad, double _credito)
	{
		super(_numero, _titular, _fechaCaducidad);
		credito=_credito;
		movimientos=new Vector();
	}

	public void retirar(double x) throws Exception
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Retirada en cajero automtico");
		x=(x*0.05<3.0 ? 3 : x*0.05); // Aadimos una comisin de un 5%, mnimo de 3 euros.
		m.setImporte(x);
		movimientos.addElement(m);
		if (x>getCreditoDisponible())
			throw new Exception("Crdito insuficiente");
	}
	public void ingresar(double x) throws Exception
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Ingreso en cuenta asociada (cajero automtico)");
		m.setImporte(x);
		movimientos.addElement(m);
		cuentaAsociada.ingresar(x);
	}
	public void pagoEnEstablecimiento(String datos, double x) throws Exception
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Compra a cr�dito en: " + datos);
		m.setImporte(x);
		movimientos.addElement(m);
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

	/**
	 * Gets credito disponible.
	 *
	 * @return the credito disponible
	 */
	public double getCreditoDisponible()
	{
		return credito-getSaldo();
	}

	/**
	 * Liquidar.
	 *
	 * @param mes the mes
	 * @param ao  the ao
	 */
	public void liquidar(int mes, int ao)
	{
		Movimiento liq=new Movimiento();
		liq.setConcepto("Liquidaci�n de operaciones tarj. cr�dito, " + (mes+1) + " de " + (ao+1900));
		double r=0.0;
		for (int i=0; i<this.movimientos.size(); i++)
		{
			Movimiento m=(Movimiento) movimientos.elementAt(i);
			if (m.getFecha().getMonth()+1==mes && m.getFecha().getYear()+1900==ao)
				r+=m.getImporte();
		}
		liq.setImporte(r);
		if (r!=0)
			cuentaAsociada.addMovimiento(liq);
	}

	public static void main(String[] args) {
		int intNum=0;

		if (intNum == 1){
			System.out.println("inalcanzable");
		}
	}
}

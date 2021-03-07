import java.util.Date;
public class Movimiento
{
	public String concepto;
	public Date fecha;
	public double importe;
	
	public Movimiento()
	{
		fecha=new Date();
	}
	public double getImporte()
	{
		return importe;
	}
	public String getConcepto()
	{
		return concepto;
	}
	public void setConcepto(String _concepto)
	{
		concepto = _concepto;
	}
	public Date getFecha()
	{
		return fecha;
	}
	public void setFecha(Date _fecha)
	{
		fecha = _fecha;
	}
	public void setImporte(double _importe)
	{
		importe = _importe;
	}
}

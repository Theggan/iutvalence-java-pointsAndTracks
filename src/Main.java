
/**
 * Test application for Point2D class
 * @author sebastienjean
 *
 */
public class Main 
{

	public static void main(String[] args) 
	{
		try 
		{
			System.out.println(new Point2D(3,2).translate(4, -2));
		} 
		catch (InvalidCoordinatesException e) 
		{	
			e.printStackTrace();
		}

	}

}

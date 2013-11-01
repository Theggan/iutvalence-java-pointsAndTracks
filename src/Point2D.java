/**
 * Represents a point in 2D -> (x, y)
 * @author sebastienjean
 *
 */
public class Point2D 
{
	/**
	 * x lower bound
	 */
	private static final int X_MIN = 0;

	/**
	 * x upper bound
	 */
	private static final int X_MAX = 42;

	/**
	 * y lower bound
	 */
	private static final int Y_MIN = 0;

	/**
	 * y upper bound
	 */
	private static final int Y_MAX = 42;

	/**
	 * x coordinate
	 */
	private final int x;

	/**
	 * y coordinate
	 */
	private final int y;

	/**
	 * Creates a new point at given coordinates
	 * @param x0 initial x value
	 * @param y0 initial y value
	 * @throws InvalidCoordinatesException if x0 or y0 are out of bounds
	 */
	public Point2D(int x0, int y0) throws InvalidCoordinatesException
	{
		if ((x0 < X_MIN)||(x0 > X_MAX)||(y0 < Y_MIN)||(y0 > Y_MAX))
			throw new InvalidCoordinatesException();
		this.x = x0;
		this.y = y0;
	}

	/**
	 * Getter for x
	 * @return x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Getter for y
	 * @return y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Returns the point corresponding to the translation of the current by given x and y values
	 * 
	 * @param dx delta x value
	 * @param dy delta y value
	 * @return a new point (x',y') as x'=x+dx and y'=y+dy
	 * @throws InvalidCoordinatesException if x' or y' are out of bounds
	 */
	public Point2D translate(int dx, int dy) throws InvalidCoordinatesException
	{
		return new Point2D(this.x+dx, this.y+dy);
	}
	
	@Override
	public int hashCode() 
	{
		return this.x + this.y;
	}

	/**
	 * Two points are considered to be equivalent if they share same both x and y values
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
	}

	/**
	 * Returns an ASCII representation of this point as "(x,y)"
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "(" + this.x + "," + this.y + ")";
	}
}

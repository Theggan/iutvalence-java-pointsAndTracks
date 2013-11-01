
/**
 * Represents a point in 3D -> (x, y, z)
 * @author sebastienjean
 *
 */
public class Point3D extends Point2D 
{
	/**
	 * Z lower bound
	 */
	private static final int Z_MIN = 0;
	
	/**
	 * Z upper bound
	 */
	private static final int Z_MAX = 42;
	
	/**
	 * z coordinate
	 */
	private final int z;
	
	/**
	 * Creates a new point at given coordinates
	 * @param x0 initial x value
	 * @param y0 initial y value
	 * @param z0 initial z value
	 * @throws InvalidCoordinatesException if x0 or y0 or z0 are out of bounds
	 */
	public Point3D(int x0, int y0, int z0) throws InvalidCoordinatesException 
	{
		super(x0, y0);
		if ((z0 < Z_MIN)||(z0 > Z_MAX))
			throw new InvalidCoordinatesException();
		this.z = z0;
	}

	/**
	 * Getter for z
	 * @return z
	 */
	public int getZ() 
	{
		return this.z;
	}

	/**
	 * Returns the point corresponding to the translation of the current by given x, y and z values
	 * 
	 * @param dx delta x value
	 * @param dy delta y value
	 * @param dz delta z value
	 * @return a new point (x',y',z') as x'=x+dx and y'=y+dy and z'=z+dz
	 * @throws InvalidCoordinatesException if x' or y' or z' are out of bounds
	 */
	public Point3D translate(int dx, int dy, int dz) throws InvalidCoordinatesException
	{
		return new Point3D(this.getX()+dx, this.getY()+dy, this.z+dz);
	}
	
	@Override
	public int hashCode() 
	{
		return super.hashCode()+ this.z;
	}

	@Override
	/**
	 * Two points are considered to be equivalent if they share same both x, y and z values
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (this.z != other.z)
			return false;
		return true;
	}

	@Override
	/**
	 * Returns an ASCII representation of this point as "(x,y,z)"
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return "(" + this.getX()+","+this.getY()+","+this.z + ")";
	}

	
}

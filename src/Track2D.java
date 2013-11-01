import java.util.Arrays;


/**
 * Represents a track, in 2D. A track is an ordered list of points to visit (limited)
 * @author sebastienjean
 *
 */
public class Track2D 
{
	/**
	 * Maximum length of tracks
	 */
	private static final int MAX_LENGTH = 20;
		
	/**
	 * points to visit (first point to visit is at offset 0)
	 */
	private Point2D[] pointsToVisit;
	
	/**
	 * track length (number of points to visit)
	 */
	private int length;
	
	/**
	 * Creates an empty track
	 */
	public Track2D()
	{
		this.pointsToVisit = new Point2D[MAX_LENGTH];
		this.length = 0;
	}

	/**
	 * Appends a point to visit
	 * @param pointToVisit the pont to append to the track
	 * @throws TooMuchPointsException if the track is already full
	 */
	public void addPointToVisit(Point2D pointToVisit) throws TooMuchPointsException
	{
		if (this.length == MAX_LENGTH) throw new TooMuchPointsException();
		this.pointsToVisit[this.length++] = pointToVisit;		
	}
	
	/**
	 * Checks if the track is a loop (i.e. the first point is the same as the last one)
	 * @return <tt>true</tt> is the track is a loop, <tt>false</tt> else
	 */
	public boolean isLoop()
	{
		if (this.length == 0) return true;		
		return (this.pointsToVisit[this.length-1].equals(this.pointsToVisit[0]));
	}
	
	/**
	 * Checks if the track contains a loop (i.e. it exists a subtrack that is a loop)
	 * @return <tt>true</tt> is the track contains a loop, <tt>false</tt> else
	 */
	public boolean containsLoop()
	{
		if (this.length == 0) return true;
		
		for (int startIndex=0; startIndex<this.length; startIndex++)
			for (int endIndex=startIndex+1;endIndex< this.length; endIndex++)
				if (this.pointsToVisit[startIndex].equals(this.pointsToVisit[endIndex])) return true;
		return false;
	}

	/**
	 * Returns an ASCII representation of this track as "startingPoint > ... > endingPoint"
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		String result = "";
		for (int pointIndex=0; pointIndex<this.length;pointIndex++)
		{
			if (pointIndex > 0) result += " > ";
			result += this.pointsToVisit[pointIndex];
		}
		return result;
	}
}

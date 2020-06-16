package Week1_perimeter_quiz;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int SumPoints=0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            SumPoints=SumPoints+1;
            prevPt = currPt;
        }
        return SumPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averageLength=0.0;
        double Num=(double)getNumPoints(s);//important!!!
        averageLength=getPerimeter(s)/Num;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
   
        Point prevPt = s.getLastPoint();
        double Largest=0.0;
        for (Point currPt : s.getPoints()) {
            if(prevPt.distance(currPt)>Largest)
                Largest=prevPt.distance(currPt);
            prevPt = currPt;
        }
        return Largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        
        Point prevPt = s.getLastPoint();
        double LargestX=prevPt.getX();
        for (Point currPt : s.getPoints()) {
            if(currPt.getX()>LargestX)
                LargestX=currPt.getX();
        
        }
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double LargestPeri=0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>LargestPeri)
                LargestPeri=length;
        }
        return LargestPeri;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        File temp = null; 
        // replace this code
        double LargestPeri=0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>LargestPeri){
                LargestPeri=length;//important!!!!
                temp=f;
            }
          
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int NumPoints=getNumPoints(s);
        double averageLength=getAverageLength(s);
        double Largest=getLargestSide(s);
        double LargestX=getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("The number of points = "+ NumPoints);
        System.out.println("The average length =" +averageLength);
        System.out.println("The length of largest side = "+ Largest);
        System.out.println("The largest value x ="+ LargestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPeri=getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter is ="+ largestPeri);
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String Filename=getFileWithLargestPerimeter();
        System.out.println("The largest perimeter is in file ="+ Filename);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}

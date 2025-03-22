
    import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class MatrixTransformations extends JPanel implements ActionListener {
    
    // Animation parameters for first square (blue)
    private double angle1 = 0;
    private double tx1 = 50;
    private double ty1 = 50;
    private double scale1 = 1.0;
    
    // Animation parameters for second square (red)
    private double angle2 = 45;
    private double tx2 = 150;
    private double ty2 = 150;
    private double scale2 = 1.5;
    
    // Animation speed factors - higher value = faster animation
    private final double ROTATION_SPEED = 6.0;
    private final double TRANSLATION_SPEED = 4.0;
    private final double SCALE_SPEED = 2.0;
    
    // Matrices for displaying transformation values
    private double[] matrix1 = new double[6];
    private double[] matrix2 = new double[6];
    
    private Timer timer;
    
    public MatrixTransformations() {
        // Timer for animation (10ms ≈ 100fps for faster animation)
        timer = new Timer(10, this);
        timer.start();
    }
    
    private void drawSquare(Graphics2D g2d, AffineTransform transform, double angle, double tx, double ty, double scale, Color color) {
        int[] xPoints = {0, 50, 50, 0, 0};
        int[] yPoints = {0, 0, 50, 50, 0};
        
        Polygon square = new Polygon(xPoints, yPoints, xPoints.length);
        Shape transformedSquare = transform.createTransformedShape(square);
        
        // Draw the square
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.draw(transformedSquare);
        
        // Fill with translucent color
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        g2d.fill(transformedSquare);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        
        // Calculate center of the transformed square
        double centerX = tx;
        double centerY = ty;
        
        // Draw angle indicator (rotation line)
        double lineLength = 70 * scale;
        double endX = centerX + lineLength * Math.cos(Math.toRadians(angle));
        double endY = centerY + lineLength * Math.sin(Math.toRadians(angle));
        
        // Draw line showing rotation angle
        g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
        g2d.setColor(color.brighter());
        g2d.draw(new Line2D.Double(centerX, centerY, endX, endY));
        
        // Draw angle value near the square
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g2d.drawString(String.format("%.0f°", angle), (float)(centerX + 10), (float)(centerY - 10));
    }
    
    // Helper method to draw a transformation matrix
    private void drawMatrix(Graphics2D g2d, double[] matrix, int x, int y, Color color, String label) {
        g2d.setColor(color);
        g2d.setFont(new Font("Monospaced", Font.BOLD, 14));
        
        // Draw matrix label
        g2d.drawString(label, x, y);
        
        // Draw matrix representation as 3x3 (even though AffineTransform only gives us 6 values)
        g2d.drawString("┌                        ┐", x, y + 20);
        g2d.drawString(String.format("│ %6.2f  %6.2f  %6.2f │", matrix[0], matrix[2], matrix[4]), x, y + 40);
        g2d.drawString(String.format("│ %6.2f  %6.2f  %6.2f │", matrix[1], matrix[3], matrix[5]), x, y + 60);
        g2d.drawString(String.format("│ %6.2f  %6.2f  %6.2f │", 0.0, 0.0, 1.0), x, y + 80);
        g2d.drawString("└                        ┘", x, y + 100);
        
        // Explain matrix components
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g2d.drawString("Where:", x, y + 120);
        g2d.drawString("• Top-left 2x2: Rotation + Scale", x, y + 140);
        g2d.drawString("• Right column: Translation (x,y)", x, y + 160);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set a black background for better contrast
        setBackground(Color.BLACK);
        
        // First square (blue)
        AffineTransform transform1 = new AffineTransform();
        transform1.scale(scale1, scale1);
        transform1.rotate(Math.toRadians(angle1));
        transform1.translate(tx1, ty1);
        transform1.getMatrix(matrix1); // Get the matrix values
        
        // Second square (red)
        AffineTransform transform2 = new AffineTransform();
        transform2.scale(scale2, scale2);
        transform2.rotate(Math.toRadians(angle2));
        transform2.translate(tx2, ty2);
        transform2.getMatrix(matrix2); // Get the matrix values
        
        // Center origin for better visibility of movement
        g2d.translate(getWidth() / 2, getHeight() / 2);
        
        // Draw the squares
        drawSquare(g2d, transform1, angle1, tx1, ty1, scale1, Color.BLUE);
        drawSquare(g2d, transform2, angle2, tx2, ty2, scale2, Color.RED);
        
        // Display parameters
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Monospaced", Font.BOLD, 14));
        g2d.drawString("Speed: " + ROTATION_SPEED + "x", -getWidth()/2 + 20, -getHeight()/2 + 20);
        
        // Show current transformation values
        String blueInfo = String.format("Blue: Scale=%.2f, Position=(%.0f,%.0f)", scale1, tx1, ty1);
        String redInfo = String.format("Red: Scale=%.2f, Position=(%.0f,%.0f)", scale2, tx2, ty2);
        g2d.drawString(blueInfo, -getWidth()/2 + 20, getHeight()/2 - 40);
        g2d.drawString(redInfo, -getWidth()/2 + 20, getHeight()/2 - 20);
        
        // Draw the transformation matrices on the left side
        drawMatrix(g2d, matrix1, -getWidth()/2 + 20, -getHeight()/2 + 60, Color.BLUE, "Blue Square Matrix:");
        drawMatrix(g2d, matrix2, -getWidth()/2 + 20, -getHeight()/2 + 240, Color.RED, "Red Square Matrix:");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Update animation parameters for first square
        angle1 = (angle1 + ROTATION_SPEED) % 360;
        tx1 = 100 * Math.sin(Math.toRadians(angle1) * 0.5 * TRANSLATION_SPEED);
        ty1 = 100 * Math.cos(Math.toRadians(angle1) * 0.7 * TRANSLATION_SPEED);
        scale1 = 0.5 + 0.5 * Math.abs(Math.sin(Math.toRadians(angle1) * 0.25 * SCALE_SPEED));
        
        // Update animation parameters for second square
        angle2 = (angle2 - ROTATION_SPEED * 0.8) % 360; // Opposite rotation
        tx2 = 150 * Math.cos(Math.toRadians(angle2) * 0.6 * TRANSLATION_SPEED);
        ty2 = 150 * Math.sin(Math.toRadians(angle2) * 0.4 * TRANSLATION_SPEED);
        scale2 = 1.0 + 0.7 * Math.abs(Math.cos(Math.toRadians(angle2) * 0.3 * SCALE_SPEED));
        
        // Redraw the panel
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Matrix Transformations with Linear Algebra");
            MatrixTransformations panel = new MatrixTransformations();
            panel.setPreferredSize(new Dimension(800, 600));
            
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}


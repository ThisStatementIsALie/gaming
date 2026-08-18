import java.awt.Color;

public class Art {
    // Everything is 7x7, as each square is 9x9 but no art touches the edges.
    private static Color colors[] = {
        new Color(255,242,204), // Zero
        new Color(106,168,79), // One
        new Color(241, 194, 50), // Two
        new Color(230,145,56), //Three
        new Color(204,0,0), // Four
        new Color(166,77,121), // Five
        new Color(103,78,167), // Six
        new Color(61,133,198), // Seven
        new Color(28,69,135), // Eight
        Color.black, // Mine
        Color.red // Flag
    };

    public static Color zero = colors[0];
    public static Color blank = new Color(215,202,164);

    public static Color one[][] = 
    {
        {colors[0], colors[0], colors[0], colors[1], colors[1], colors[0], colors[0]}, 
        {colors[0], colors[0], colors[1], colors[1], colors[1], colors[0], colors[0]}, 
        {colors[0], colors[1], colors[1], colors[1], colors[1], colors[0], colors[0]}, 
        {colors[0], colors[0], colors[1], colors[1], colors[1], colors[0], colors[0]}, 
        {colors[0], colors[0], colors[1], colors[1], colors[1], colors[0], colors[0]}, 
        {colors[0], colors[0], colors[1], colors[1], colors[1], colors[0], colors[0]}, 
        {colors[0], colors[1], colors[1], colors[1], colors[1], colors[1], colors[0]}
    };
    
    public static Color two[][] =
    {
        {colors[0], colors[2], colors[2], colors[2], colors[2], colors[2], colors[0]},
        {colors[2], colors[2], colors[2], colors[2], colors[2], colors[2], colors[2]},
        {colors[2], colors[2], colors[0], colors[0], colors[2], colors[2], colors[2]},
        {colors[0], colors[0], colors[0], colors[2], colors[2], colors[2], colors[0]},
        {colors[0], colors[0], colors[2], colors[2], colors[2], colors[0], colors[0]},
        {colors[0], colors[2], colors[2], colors[2], colors[0], colors[0], colors[0]},
        {colors[2], colors[2], colors[2], colors[2], colors[2], colors[2], colors[2]}
    };

    public static Color three[][] =
    {
        {colors[0], colors[3], colors[3], colors[3], colors[3], colors[3], colors[0]},
        {colors[3], colors[3], colors[3], colors[3], colors[3], colors[3], colors[3]},
        {colors[3], colors[3], colors[0], colors[0], colors[0], colors[3], colors[3]},
        {colors[0], colors[0], colors[0], colors[3], colors[3], colors[3], colors[0]},
        {colors[3], colors[3], colors[0], colors[0], colors[0], colors[3], colors[3]},
        {colors[3], colors[3], colors[3], colors[3], colors[3], colors[3], colors[3]},
        {colors[0], colors[3], colors[3], colors[3], colors[3], colors[3], colors[0]} 
    };

    public static Color four[][] =
    {
        {colors[0], colors[0], colors[0], colors[0], colors[4], colors[4], colors[0]},
        {colors[0], colors[0], colors[0], colors[4], colors[4], colors[4], colors[0]},
        {colors[0], colors[0], colors[4], colors[4], colors[4], colors[4], colors[0]},
        {colors[0], colors[4], colors[4], colors[0], colors[4], colors[4], colors[0]},
        {colors[4], colors[4], colors[0], colors[0], colors[4], colors[4], colors[4]},
        {colors[4], colors[4], colors[4], colors[4], colors[4], colors[4], colors[4]},
        {colors[0], colors[0], colors[0], colors[0], colors[4], colors[4], colors[0]} 
    };

    public static Color five[][] =
    {
        {colors[5], colors[5], colors[5], colors[5], colors[5], colors[5], colors[5]},
        {colors[5], colors[5], colors[0], colors[0], colors[0], colors[0], colors[0]},
        {colors[5], colors[5], colors[0], colors[0], colors[0], colors[0], colors[0]},
        {colors[5], colors[5], colors[5], colors[5], colors[5], colors[5], colors[5]},
        {colors[0], colors[0], colors[0], colors[0], colors[0], colors[5], colors[5]},
        {colors[5], colors[5], colors[0], colors[0], colors[0], colors[5], colors[5]},
        {colors[0], colors[5], colors[5], colors[5], colors[5], colors[5], colors[0]} 
    };

    public static Color six[][] =
    {
        {colors[0], colors[6], colors[6], colors[6], colors[6], colors[6], colors[0]},
        {colors[6], colors[6], colors[0], colors[0], colors[0], colors[6], colors[6]},
        {colors[6], colors[6], colors[0], colors[0], colors[0], colors[0], colors[0]},
        {colors[6], colors[6], colors[6], colors[6], colors[6], colors[6], colors[6]},
        {colors[6], colors[6], colors[0], colors[0], colors[0], colors[6], colors[6]},
        {colors[6], colors[6], colors[0], colors[0], colors[0], colors[6], colors[6]},
        {colors[0], colors[6], colors[6], colors[6], colors[6], colors[6], colors[0]} 
    };

    public static Color seven[][] =
    {
        {colors[7], colors[7], colors[7], colors[7], colors[7], colors[7], colors[7]},
        {colors[7], colors[7], colors[7], colors[7], colors[7], colors[7], colors[7]},
        {colors[0], colors[0], colors[0], colors[0], colors[7], colors[7], colors[7]},
        {colors[0], colors[0], colors[0], colors[7], colors[7], colors[7], colors[0]},
        {colors[0], colors[0], colors[7], colors[7], colors[7], colors[0], colors[0]},
        {colors[0], colors[7], colors[7], colors[7], colors[0], colors[0], colors[0]},
        {colors[7], colors[7], colors[7], colors[0], colors[0], colors[0], colors[0]} 
    };

    public static Color eight[][] =
    {
        {colors[0], colors[8], colors[8], colors[8], colors[8], colors[8], colors[0]},
        {colors[8], colors[8], colors[0], colors[0], colors[0], colors[8], colors[8]},
        {colors[8], colors[8], colors[0], colors[0], colors[0], colors[8], colors[8]},
        {colors[0], colors[8], colors[8], colors[8], colors[8], colors[8], colors[0]},
        {colors[8], colors[8], colors[0], colors[0], colors[0], colors[8], colors[8]},
        {colors[8], colors[8], colors[0], colors[0], colors[0], colors[8], colors[8]},
        {colors[0], colors[8], colors[8], colors[8], colors[8], colors[8], colors[0]} 
    };

    public static Color nine[][] =
    {
        {colors[9], colors[0], colors[0], colors[9], colors[0], colors[0], colors[9]},
        {colors[0], colors[10], colors[10], colors[10], colors[10], colors[10], colors[0]},
        {colors[0], colors[10], colors[9], colors[9], colors[9], colors[10], colors[0]},
        {colors[9], colors[10], colors[10], colors[10], colors[10], colors[10], colors[9]},
        {colors[0], colors[9], colors[9], colors[9], colors[10], colors[10], colors[0]},
        {colors[0], colors[10], colors[10], colors[10], colors[10], colors[10], colors[0]},
        {colors[9], colors[0], colors[0], colors[9], colors[0], colors[0], colors[9]} 
    };

    public static Color mine[][] =
    {
        {colors[9], colors[0], colors[0], colors[9], colors[0], colors[0], colors[9]},
        {colors[0], colors[9], colors[9], colors[9], colors[9], colors[9], colors[0]},
        {colors[0], colors[9], colors[9], colors[9], colors[9], colors[9], colors[0]},
        {colors[9], colors[9], colors[9], colors[9], colors[9], colors[9], colors[9]},
        {colors[0], colors[9], colors[9], colors[9], colors[9], colors[9], colors[0]},
        {colors[0], colors[9], colors[9], colors[9], colors[9], colors[9], colors[0]},
        {colors[9], colors[0], colors[0], colors[9], colors[0], colors[0], colors[9]} 
    };

    public static Color flag[][] =
    {
        {colors[0], colors[0], colors[0], colors[9], colors[9], colors[0], colors[0]},
        {colors[0], colors[0], colors[10], colors[9], colors[9], colors[0], colors[0]},
        {colors[0], colors[10], colors[10], colors[9], colors[9], colors[0], colors[0]},
        {colors[10], colors[10], colors[10], colors[9], colors[9], colors[0], colors[0]},
        {colors[0], colors[0], colors[0], colors[9], colors[9], colors[0], colors[0]},
        {colors[0], colors[0], colors[0], colors[9], colors[9], colors[0], colors[0]},
        {colors[0], colors[9], colors[9], colors[9], colors[9], colors[9], colors[9]} 
    };
}
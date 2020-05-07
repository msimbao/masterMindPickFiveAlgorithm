package properProject;

import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsText;
import comp127graphics.Path;
import comp127graphics.Point;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static comp127graphics.FontStyle.BOLD;

public class Instructions {
    private static ColorManager colorKey = new ColorManager();

    public static String humanManual() {
//
        String words = (
                "Hello! Welcome to our game of Mastermind \n" +
                ("\n") +
                ("\n") +
                ("In this game there is a hidden code generated by the computer written using 4 color coded balls \n") +
                ("The balls can be selected via number according to the color scheme\n 0: Red\n 1: Orange\n 2: Yellow\n 3: Green\n 4: Blue\n 5: Green\n 6: Purple \n") +
                ("\n") +
                ("\n") +
                ("Your Job is to select 4 balls e.g. 0011 is red red orange orange \n and try to guess the original code based on color and position \n") +
                ("We will give you feedback in the form of white and black balls up to a total of 4 for each ball \n") +
                ("A black ball indicates the position and color of a ball have been guessed correctly \n") +
                ("A white ball indicates the color of a ball has been guessed correctly, but not the position \n") +
                ("You can try as many times as you want before it quits \n") +
                ("\n") +
                ("\n") +
                ("Or You can ask the computer to play and our algorithm will always solve it in five moves. \n Click this banner to close it and play the game in your Java console"));
        return words;
    }

    public String computerManual() {
        String words = ("============================================================================================" +
                "Please wait while I (your computer) do my awesome thing and solve this puzzle! \n" +
                ("\n") +
                ("============================================================================================"));
        return words;
    }

    public GraphicsGroup guiBanner() {
        GraphicsGroup banner = new GraphicsGroup();
        Point point1 = new Point(0,0);
        Point point2 = new Point(750,0);
        Point point3 = new Point(750,400);
        Point point4 = new Point(650,450);
        Point point5 = new Point(100,450);
        Point point6 = new Point(0,400);
        Point point7 = new Point(0,0);

        List<Point> pathPoints = List.of(point1,point2,point3,point4,point5,point6,point7);

        Path path = new Path(pathPoints);
        path.setFillColor(colorKey.toColor(8));
        path.setStrokeWidth(20);
        banner.add(path);

        var wrapper = new Object(){ double ordinal = 40; };

        String str = humanManual();
        Stream<String> lines = str.lines();
        lines.forEach(out -> {
            GraphicsText text = new GraphicsText(out,20,wrapper.ordinal);
            text.setFontStyle(BOLD);
            banner.add(text);
            wrapper.ordinal+= 15;
        });

        banner.setPosition(120,120);

        return banner;
    }

}


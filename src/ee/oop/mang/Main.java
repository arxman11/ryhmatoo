package ee.oop.mang;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	String[] map = {"                ",
					"#.#. ..         ",
					"##### ##########" };
	private int canvasW = 800;
	private static int canvasH = 600;

	final private static int size = 50;

	static GraphicsContext g;

	@Override
	public void start(Stage stage) {

		Canvas canvas = new Canvas(canvasW, canvasH);
		g = canvas.getGraphicsContext2D();
		g.setFill(Color.BLACK);
		g.fillRect(0, 0, canvasW, canvasH);
		g.fill();

		loadMap(map);

		Group juur = new Group(canvas);
		stage.setScene(new Scene(juur));
		stage.show();

	}

	public static void loadMap(String[] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length(); j++) {
				char curC = map[i].charAt(j);
				if (curC == '#') {
					g.setFill(Color.GREEN);
					g.fillRect(j * size,
							i * size + canvasH - size * map.length, size, size);
				} else if (curC == '.') {
					g.setFill(Color.RED);
					g.fillOval(j * size,
							i * size + canvasH - size * map.length, size, size);
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

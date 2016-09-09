package com.marta.springernaturetest.domainbeans;

import java.util.ArrayList;
import java.util.List;

import com.marta.springernaturetest.Constants;

public class CanvasImpl implements Canvas {

	public static CanvasImpl getInstance() {
		return SingletonHelper.INSTANCE;
	}

	private static class SingletonHelper {
		private static CanvasImpl INSTANCE = new CanvasImpl();
	}

	private CanvasImpl() {
	}

	private char[][] matrix;
	private int columns;
	private int rows;

	@Override
	public void initialize(CanvasArguments dimensions) {
		columns = dimensions.getNumCol() + 2;
		rows = dimensions.getNumRows() + 2;
		matrix = new char[rows][columns];

		for (int i = 0; i < columns; i++) {
			matrix[0][i] = Constants.ROW_CHARACTER.charAt(0);
		}
		for (int i = 1; i < rows-1; i++) {
			matrix[i][0] = Constants.COLUMN_CHARACTER.charAt(0);
			for (int j = 1; j < columns ; j++) {
				matrix[i][j] = Constants.WHITE_SPACE.charAt(0);
			}
			matrix[i][columns-1] = Constants.COLUMN_CHARACTER.charAt(0);
		}
		for (int i = 0; i < columns; i++) {
			matrix[rows-1][i] = Constants.ROW_CHARACTER.charAt(0);
		}

	}

	@Override
	public void addLine(PairPointArguments points) {
		boolean isVerticalLine = points.getPointX().getY() == points
				.getPointY().getY();
		boolean isHorizontalLine = points.getPointX().getX() == points
				.getPointY().getX();
		
		// straight horizontal line, 
		// calculate where the line begin and the length and then draw
		if (isHorizontalLine) {
			int lineLenght = Math.abs(points.getPointX().getY()
					- points.getPointY().getY());
			int begin = Math.min(points.getPointX().getY(), points.getPointY()
					.getY());

			for (int i = begin; i < begin + lineLenght+1 ; i++) {
				matrix[points.getPointX().getX()][i] = Constants.LINE_CHARACTER
						.charAt(0);
			}

		} else if (isVerticalLine) {
			int lineLenght = Math.abs(points.getPointX().getX()
					- points.getPointY().getX());
			int begin = Math.min(points.getPointX().getX(), points.getPointY()
					.getX());

			for (int i = begin; i < begin+lineLenght+1; i++) {
				matrix[i][points.getPointX().getY()] = Constants.LINE_CHARACTER
						.charAt(0);
			}

		}

	}

	@Override
	public void addRectangule(PairPointArguments points) {
		int width = Math.abs(points.getPointX().getY()
				- points.getPointY().getY()) + 1;
		int height = Math.abs(points.getPointX().getX()
				- points.getPointY().getX()) + 1;
		int beginX = Math.min(points.getPointX().getX(), points.getPointY()
				.getX());
		int beginY = Math.min(points.getPointX().getY(), points.getPointY()
				.getY());
		
		// Draw horizontal upper border
		for (int j = beginY; j < beginY + width; j++) {
			matrix[beginX][j] = Constants.LINE_CHARACTER.charAt(0);
		}
		
		// Draw vertical border
		for (int i = beginX + 1; i < beginX + height - 1; i++) {

			matrix[i][beginY] = Constants.LINE_CHARACTER.charAt(0);
			matrix[i][beginY + width - 1] = Constants.LINE_CHARACTER
					.charAt(0);
		}
		// Draw bottom border
		for (int j = beginY; j < beginY + width; j++) {
			matrix[beginX + height - 1][j] = Constants.LINE_CHARACTER
					.charAt(0);
		}

	}

	@Override
	public void addFillingArea(AreaArguments area) {
		Point begin = Point.createInstance(area.getBegin(), area.getEnd());
		
		//Fill the area recursively
		addFillingArea(begin, area.getCharacter());

	}

	private void addFillingArea(Point begin, char character) {
		if (matrix[begin.getX()][begin.getY()] == ' ') {
			matrix[begin.getX()][begin.getY()] = character;
		}
		for (Point point : getFreeNeighbords(begin)) {
			addFillingArea(point, character);
		}
	}

	@Override
	public void display() {
		for (int i = 0; i < rows; i++) {
			StringBuilder line = new StringBuilder();
			for (int j = 0; j < columns; j++) {
				line.append(String.valueOf(matrix[i][j]));
			}
			System.out.println(line.toString());
		}

	}

	//Used for test
	@Override
	public char[][] getMatrixRepresentation() {
		return matrix;
	}

	// Calculate the empty neighbors of a given cell
	private List<Point> getFreeNeighbords(Point begin) {
		List<Point> neighbords = new ArrayList<>();
		if (matrix[begin.getX() + 1][begin.getY()] == ' ') {
			neighbords
					.add(Point.createInstance(begin.getX() + 1, begin.getY()));
		}
		if (matrix[begin.getX()][begin.getY() + 1] == ' ') {
			neighbords
					.add(Point.createInstance(begin.getX(), begin.getY() + 1));
		}
		if (matrix[begin.getX() - 1][begin.getY()] == ' ') {
			neighbords
					.add(Point.createInstance(begin.getX() - 1, begin.getY()));
		}
		if (matrix[begin.getX()][begin.getY() - 1] == ' ') {
			neighbords
					.add(Point.createInstance(begin.getX(), begin.getY() - 1));
		}
		return neighbords;
	}

}

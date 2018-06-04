import java.util.*;

class Watersheds {

  // The final map that shows where the water will run
  public static String waterMap[][];
  // The number of different drainage basins
  public static int charactersUsed;

  public static void recursiveWaterMap(int altitudeMap[][], int row, int column, int mapH, int mapW){
    // The row & column position of an area with a lower altitude
    int lowestRow = row;
    int lowestColumn = column;
    int lowestAltitude = altitudeMap[row][column];

    // Checks the position to the North
    if (row != 0 ){
      if (altitudeMap[row-1][column] < lowestAltitude){
        lowestAltitude = altitudeMap[row-1][column];
        lowestRow = row - 1;
        lowestColumn = column;
      }
    }
    // Checks the position to the West
    if (column != 0){
      if (altitudeMap[row][column-1] < lowestAltitude){
        lowestAltitude = altitudeMap[row][column-1];
        lowestRow = row;
        lowestColumn = column -1;
      } 
    }
    // Checks the position to the East
    if (column < mapW -1){
      if (altitudeMap[row][column + 1] < lowestAltitude){
        lowestAltitude = altitudeMap[row][column+1];
        lowestRow = row;
        lowestColumn = column +1;
      }
    }
    // Checks the position to the South
    if (row < mapH - 1){
      if (altitudeMap[row + 1][column] < lowestAltitude){
        lowestAltitude = altitudeMap[row + 1][column];
        lowestRow = row + 1;
        lowestColumn = column;
      }
    }
    // If a lower altitude is found
    if(lowestAltitude != altitudeMap[row][column]){
      // Call this method again to find out if the lower altitude also has a lower altitude
      recursiveWaterMap(altitudeMap, lowestRow, lowestColumn, mapH, mapW);
      // Once the lowest altitude has been found, label all positions that were passed through
      waterMap[row][column] = waterMap[lowestRow][lowestColumn];
    }
    else{
      // If the lowest altitude in the path hasn't been marked yet,
      // mark it and increment charactersused
      if (waterMap[lowestRow][lowestColumn] == null){
        waterMap[row][column] = "" + (char) ('a' + charactersUsed);
        charactersUsed++;
      }
      // If the lowest altitude in the path has already been marked
      // Assign its mark to the current path
      else{
        waterMap[row][column] = waterMap[lowestRow][lowestColumn];
      }
    } 
  }

  public static String[][] altitudeMap(int altitudeMap[][], int mapH, int mapW){
    // Reset waterMap & charactersused
    waterMap = new String[mapH][mapW];
    charactersUsed = 0;

    // Find the lowest altitude for each position on the map
    // provided it hasn't already been labelled
    for(int i = 0; i < mapH; i++){
        for(int j = 0; j < mapW; j++){
          if(waterMap[i][j] == null){
            recursiveWaterMap(altitudeMap,i,j,mapH,mapW);
          }
        }
      }
    return waterMap;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();

    // For every testcase 
    for(int i = 0; i < testCases; i++ ){
      int mapH = scanner.nextInt();
      int mapW = scanner.nextInt();
      int map[][] = new int[mapH][mapW];
      for(int j = 0; j < mapH; j++){
        for(int k = 0; k < mapW; k++){
          map[j][k] = scanner.nextInt();
        }
      }

      System.out.println("Case #" + (i+1) + ": ");
      String output[][] = altitudeMap(map, mapH,mapW);

      for(int j = 0; j < mapH; j++){
        for(int k = 0; k < mapW; k++){
          System.out.print(output[j][k] + " ");
        }
          System.out.println();
      }
    }
    scanner.close();
  }
}

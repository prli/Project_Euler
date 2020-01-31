package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Amazon {
    public List<Integer> cellCompete(int[] states, int days)
    {
        int[] newState = new int[states.length];
        while (days > 0) {
            if (states[1] == 0) {
                newState[0] = 0;
            } else {
                newState[0] = 1;
            }

            if (states[states.length - 2] == 0) {
                newState[states.length - 1] = 0;
            } else {
                newState[states.length - 1] = 1;
            }

            for (int i = 1; i < states.length - 1; i++) {
                if (states[i - 1] != states[i + 1]) {
                    newState[i] = 1;
                } else {
                    newState[i] = 0;
                }
            }
            System.arraycopy(newState, 0, states, 0, states.length);
            days--;
        }

        return Arrays.stream(newState).boxed().collect(Collectors.toList());
    }

    public int generalizedGCD(int num, int[] arr)
    {
        int gcd = 1;
        List<Integer> sorted = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        for (int i = 1; i <= sorted.get(0); i++) {
            boolean isGcd = true;
            for (int value : arr) {
                if (value % i != 0) {
                    isGcd = false;
                    break;
                }
            }
            if (isGcd) {
                gcd = i;
            }
        }
        return gcd;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews)
    {
        Map<String, Integer> competitorsMentions = new HashMap<>();
        for (String competitorName : competitors) {
            competitorsMentions.put(competitorName, 0);
        }

        for (String review : reviews) {
            for (String competitorName : competitorsMentions.keySet()) {
                if (review.contains(competitorName)) {
                    int mentions = competitorsMentions.get(competitorName) + 1;
                    competitorsMentions.put(competitorName, mentions);
                }
            }
        }

        List<String> collect = competitorsMentions.entrySet().stream()
                //sort by value decreasing, then sort alphabetically
                .sorted(
                        Entry.<String, Integer>comparingByValue()
                                .reversed()
                                .thenComparing(Entry.comparingByKey()))
                .map(Entry::getKey)
                .collect(Collectors.toList());
        //take sublist for top n competitiors
        return new ArrayList<>(collect.subList(0, Math.min(numCompetitors, topNCompetitors)));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumHours(int rows, int columns, List<List<Integer>> grid)
    {
        boolean isAllZeros = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    isAllZeros = false;
                }
            }
        }

        if (isAllZeros) {
            return -1;
        }

        Integer[][] arr;
        int hoursTaken = 0;
        boolean isComplete;

        do {
            isComplete = true;
            arr = new Integer[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid.get(i).get(j) == 1) {
                        arr[i][j] = 1;
                        continue;
                    }

                    boolean north = false;
                    boolean south = false;
                    boolean west = false;
                    boolean east = false;

                    if (i - 1 >= 0) {
                        north = grid.get(i - 1).get(j) == 1;
                    }

                    if (i + 1 < rows) {
                        south = grid.get(i + 1).get(j) == 1;
                    }

                    if (j - 1 >= 0) {
                        west = grid.get(i).get(j - 1) == 1;
                    }

                    if (j + 1 < columns) {
                        east = grid.get(i).get(j + 1) == 1;
                    }

                    if (north || south || west || east) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
            hoursTaken++;

            List<List<Integer>> newGrid = new ArrayList<>();
            for (Integer[] ints : arr) {
                newGrid.add(Arrays.asList(ints));
            }
            grid = newGrid;

        } while (!isComplete);

        return hoursTaken;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int shortestPath(int rows, int columns, List<List<Integer>> grid)
    {
        Integer[][] arr = new Integer[rows][columns];

        int hoursTaken = -1;
        boolean isComplete = true;
        do {
            for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < columns - 1 ; j++) {
                    if (grid.get(i).get(j) == 1) {
                        continue;
                    }

                    boolean north = grid.get(i - 1).get(j) == 1;
                    boolean south = grid.get(i + 1).get(j) == 1;
                    boolean west = grid.get(i).get(j - 1) == 1;
                    boolean east = grid.get(i).get(j + 1) == 1;

                    if (north || south || west || east) {
                        arr[i][j] = 1;
                    } else {
                        isComplete = false;
                    }
                }
            }
            hoursTaken++;
            List<List<Integer>> newGrid = new ArrayList<>();
            for (Integer[] ints : arr) {
                newGrid.add(Arrays.asList(ints));
            }
            grid = newGrid;

        } while (!isComplete);

        return hoursTaken;
    }

    public static void main(String[] args) {
        Integer[][] gridArr = new Integer[][] {
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,0,0,1},
        };

        Integer[][] gridArr2 = new Integer[][] {
                {1,1,1,1,0},
                {1,1,0,0,0},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
        };
        List<List<Integer>> grid = new ArrayList<>();
        for (Integer[] ints : gridArr) {
            grid.add(Arrays.asList(ints));
        }
        new Amazon().minimumHours(5, 5, grid);
    }
}

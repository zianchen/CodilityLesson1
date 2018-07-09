package com.company;

public class TapeEquilibrium {
  public int solution(int[] A) {
    // write your code in Java SE 8
    int N = A.length;
    int[] prefix = new int[N];
    prefix[0] = A[0];
    for (int i = 1; i < N; i++) {
      prefix[i] += prefix[i-1] + A[i];
    }
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < N - 1; j++) {
      int diff = Math.abs(prefix[j] - (prefix[N-1] - prefix[j]));
      min = Math.min(min, diff);
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public static void main(String[] args) {
    TapeEquilibrium te = new TapeEquilibrium();
    int[] input = new int[]{-1000, 1000};
    int res = te.solution(input);
    System.out.println(res);
  }
}

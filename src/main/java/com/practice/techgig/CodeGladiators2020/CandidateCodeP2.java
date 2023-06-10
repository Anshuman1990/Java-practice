package com.practice.techgig.CodeGladiators2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CandidateCodeP2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        List<Long> result = new ArrayList<>(T);
        while (T > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            List<Long> teamGTeamMembers = Stream.of(scanner.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            List<Long> opponentTeamMembers = Stream.of(scanner.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            result.add(winNumber(N, teamGTeamMembers, opponentTeamMembers));
            T--;
        }
        result.forEach(System.out::println);
    }

    static long winNumber(int N, List<Long> teamGTeamMembers, List<Long> opponentTeamMembers) {
        teamGTeamMembers = teamGTeamMembers.stream().sorted().collect(Collectors.toList());
        opponentTeamMembers = opponentTeamMembers.stream().sorted().collect(Collectors.toList());
        int result = 0;
        for (int i = 0; i < N; i++) {
            long gMember = teamGTeamMembers.get(i);
            for (int j = 0; j < opponentTeamMembers.size(); j++) {
                long opponentMember = opponentTeamMembers.get(j);
                if (gMember > opponentMember) {
                    result++;
                    opponentTeamMembers.remove(j);
                    break;
                }
            }
        }
        return result;
    }
}

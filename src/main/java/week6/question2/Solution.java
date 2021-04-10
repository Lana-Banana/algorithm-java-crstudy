/*
    https://programmers.co.kr/learn/courses/30/lessons/42890
    [프로그래머스][2019 KAKAO BLIND RECRUITMENT] 후보키
 */
package week6.question2;

import java.util.ArrayList;
import java.util.HashMap;


class Solution {
    public int solution(String[][] relation) {

        int candidateKeyCount = 0;
        ArrayList<Integer> notUniqueAttributes = new ArrayList<>();

        for (int i = 0; i < relation[0].length; i++) {
            String[] vals = new String[relation.length];
            for (int j = 0; j < relation.length; j++) {
                vals[j] = relation[j][i];
            }
            if (isUnique(vals)) candidateKeyCount++;
            else notUniqueAttributes.add(i); // 유니크하지 않은 컬럼 인덱스 저장
        }

        for (int i = 0; i < notUniqueAttributes.size() - 1; i++) {
            for (int j = i + 1; j < notUniqueAttributes.size(); j++) {
                String[] vals = new String[relation.length];
                for (int k = 0; k < relation[0].length; k++) {
                    vals[k] = relation[k][notUniqueAttributes.get(i)] + relation[k][notUniqueAttributes.get(j)];
                }
                if (isUnique(vals)) {
                    candidateKeyCount++;
                } else {
                    if (j + 1 < notUniqueAttributes.size())
                        candidateKeyCount += makeCandidateKey(vals, notUniqueAttributes, j + 1, relation, 3);
                }
            }
        }
        return candidateKeyCount;
    }

    private static int makeCandidateKey(String[] vals, ArrayList<Integer> notUniqueAttributes, int nextAttrIndex, String[][] relation, int minimality) {
        int candidateKeyCount = 0;
        for (int k = 0; k < vals.length; k++) {
            vals[k] = vals[k] + relation[k][notUniqueAttributes.get(nextAttrIndex)];
        }
        if (isUnique(vals)) candidateKeyCount++;
        else if (nextAttrIndex + 1 < notUniqueAttributes.size())
            candidateKeyCount += makeCandidateKey(vals, notUniqueAttributes, nextAttrIndex + 1, relation, minimality + 1);
        return candidateKeyCount;
    }

    private static boolean isUnique(String[] attributes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String a : attributes) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        return hm.size() == attributes.length;
    }
}
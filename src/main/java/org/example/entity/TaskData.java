package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String user) {
        switch (user.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default:
                return new HashSet<>();
        }
    }

    // Union metodları
    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> s : sets) {
            unionSet.addAll(s);
        }
        return unionSet;
    }

    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersectSet = new HashSet<>(set1);
        intersectSet.retainAll(set2);
        return intersectSet;
    }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        return differenceSet;
    }
}

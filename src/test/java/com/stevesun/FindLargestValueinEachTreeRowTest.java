package com.stevesun;

import com.stevesun.common.classes.TreeNode;
import com.stevesun.solutions.FindLargestValueinEachTreeRow;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindLargestValueinEachTreeRowTest {
    private static FindLargestValueinEachTreeRow test;
    private static List<Integer> expected;
    private static List<Integer> actual;
    private static TreeNode root;

    @BeforeClass
    public static void setup(){
        test = new FindLargestValueinEachTreeRow();
    }

    @Before
    public void setupForEachTest(){
        expected = new ArrayList<>();
        actual = new ArrayList<>();
        root = new TreeNode(0);
    }

    @Test
    public void test1(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right= new TreeNode(2);
        expected = Arrays.asList(1, 3);
        actual = test.largestValues(root);
        assertEquals(expected, actual);

    }

    @Test
    public void test2(){
        expected = new ArrayList<>();
        actual = test.largestValues(null);
        assertEquals(expected, actual);

    }
}

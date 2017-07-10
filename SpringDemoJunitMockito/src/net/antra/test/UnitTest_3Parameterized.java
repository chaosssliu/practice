package net.antra.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import net.antra.deotemp.utility.MathUtility;

@RunWith(Parameterized.class)
public class UnitTest_3Parameterized {
	private int first;
	private int second;
	private int result;
	
	public UnitTest_3Parameterized(int result,int first, int second) {
		this.first = first;
		this.second = second;
		this.result = result;
	}
	
	@Parameters
    public static Collection<Integer[]> addedNumbers() {
        return Arrays.asList(new Integer[][] { { 3, 1, 2 }, { 5, 2, 3 },
                { 7, 3, 4 }, { 9, 4, 5 } ,{1,1,1}});
    }

    @Test
    public void sum() {
        assertTrue(result == MathUtility.sum(first, second));
    }

}

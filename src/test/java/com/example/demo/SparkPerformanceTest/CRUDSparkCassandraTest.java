package com.example.demo.SparkPerformanceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by THANH NGA on 7/19/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDSparkCassandraTest {

    @Test
    public void TestSaveObject(){
        /**
         * Step:
         * 1. Load data to memory (10000 record)
         * 2. Create new object
         * 3. Get Time
         * 4. Run save method in spark repository
         * 5. Get Time
         * 6. Run save method in cassandra repository
         * 7. Get Time
         * 8. Compare Time
         */

    }

    @Test
    public void TestDeleteObject(){

    }

    @Test
    public void TestUpdateObject(){

    }

    @Test
    public void TestQuerySingleTable(){

    }

    @Test
    public void TestJoinTables(){

    }


}

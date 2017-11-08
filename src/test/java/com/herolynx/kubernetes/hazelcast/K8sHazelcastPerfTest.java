package com.herolynx.kubernetes.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.security.UsernamePasswordCredentials;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class K8sHazelcastPerfTest {

    private static HazelcastInstance client;

    @BeforeClass
    public static void setUp() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setCredentials(new UsernamePasswordCredentials("huuuge-cache", "huuuge"));
//        clientConfig.setCredentials(new UsernamePasswordCredentials("k8s", "k8s"));
        client = HazelcastClient.newHazelcastClient(clientConfig);
    }

    @AfterClass
    public static void tearDown() {
        client.shutdown();
    }

    @Test
    public void shouldPutAndReadSingleValue() {
        IMap<String, String> map = client.getMap("k8s-perf-test");
        map.set("k8s", "works");
        assertThat(map.get("k8s"), is("works"));
    }

    @Test
    public void shouldPutData() {
        IMap<String, String> map = client.getMap("k8s-perf-test");
        for (int i = 0; i < 1000; i++) {
            map.set("k8s-" + 0, "works");
        }
    }

    @Test
    public void shouldReadPutData() {
        IMap<String, String> map = client.getMap("k8s-perf-test");
        for (int i = 0; i < 1000; i++) {
            assertThat(map.get("k8s-" + 0), is("works"));
        }
    }

}

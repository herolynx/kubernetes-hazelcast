package com.herolynx.kubernetes.hazelcast;

import com.hazelcast.core.Hazelcast;

public class K8sHazelcast {

    public static void main(String... args) {
        Hazelcast.newHazelcastInstance();
    }

}

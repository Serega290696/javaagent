#!/usr/bin/env bash
mvn clean package
java -javaagent:target/agentCriminal.jar com.agent.Criminal
pipeline {
    agent any

    stages {
        stage('Build and Test') {
            steps {
                // Compile the main code
                sh 'javac  src/main/java/org/example/AddNumbers.java'
                // Compile the test code
                sh 'javac -cp .:~/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.9.2/junit-jupiter-api-5.9.2.jar:~/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.9.2/junit-jupiter-engine-5.9.2.jar src/test/java/AddNumbersTest.java'
                // Run the JUnit tests
                sh 'java -cp .:~/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.9.2/junit-jupiter-api-5.9.2.jar:~/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.9.2/junit-jupiter-engine-5.9.2.jar:~/.m2/repository/org/junit/platform/junit-platform-console-standalone/1.8.0-M1/junit-platform-console-standalone-1.8.0-M1.jar org.junit.platform.console.ConsoleLauncher --classpath .:~/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.9.2/junit-jupiter-api-5.9.2.jar:~/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.9.2/junit-jupiter-engine-5.9.2.jar --scan-classpath --disable-ansi-colors'
            }
        }
    }

    post {
        always {
            // Archive test reports and other post-processing tasks
            archiveArtifacts artifacts: '**/TEST-*.xml', allowEmptyArchive: true
        }

        success {
            echo 'All tests passed! Build successful.'
        }

        failure {
            echo 'Tests failed! Build unsuccessful.'
        }
    }
}

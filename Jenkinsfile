pipeline {
    agent any

    stages {
        stage('Build and Test') {
            steps {
                // Compile the main code
                sh 'javac src/main/java/org/example/AddNumbers.java'
                // Compile the test code
                sh 'javac -cp .:junit-jupiter-api-5.9.2.jar:junit-4.13.2.jar src/test/java/AddNumbersTest.java'
                // Run the JUnit tests
                sh 'java -cp .:junit-jupiter-api-5.9.2.jar:junit-4.13.2.jar:junit-platform-console-standalone-1.8.0-M1.jar org.junit.platform.console.ConsoleLauncher --classpath . --scan-classpath --disable-ansi-colors'
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

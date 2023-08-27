pipeline {
    agent any

    stages {
        stage('Build and Test') {
            steps {
                // Compile the main code
                sh 'javac src/AddNumbers.java'
                // Compile the test code
                sh 'javac -cp .:junit-platform-console-standalone-1.8.0-M1.jar src/AddNumbersTest.java'
                // Run the JUnit tests
                sh 'java -jar junit-platform-console-standalone-1.8.0-M1.jar --class-path . --scan-classpath --disable-ansi-colors'
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

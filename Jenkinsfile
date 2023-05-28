pipeline {
    agent any
     triggers {
            cron('H 4/* 0 0 1-5')
        }
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true//捕获符合模式（``**/target/*.jar``）匹配的交付件并将其保存到 Jenkins master 节点以供后续获取。
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo 'Building..'
            }
        }
       /* stage('Test') {
            steps {
                sh './gradlew check'
                echo 'Testing..'
            }
        } */
        //post {
           // always {
              //  junit 'build/reports/**/*.xml'
          //  }
       // }
        stage('Deploy') {
             when {
                      expression {
                        currentBuild.result == null || currentBuild.result == 'SUCCESS'
                      }
                   }
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                                retry(5) {
                                    sh './flakey-deploy.sh'
                                }
                            }
                sh 'make publish'
                echo 'Deploying....'
            }
        }
    }
}
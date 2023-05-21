pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
                sh 'make' //sh 步骤调用 make 命令，只有命令返回的状态码为零时才会继续。任何非零的返回码都将使流水线失败。
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
        }*/
        post {
            always {
                junit 'build/reports/**/*.xml'
            }
        }
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

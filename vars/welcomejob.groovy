def call(String jenkins_pipeline_name='User',String jenkins_lib_name='User') {
                pipeline {
                  agent any
                   stages {
                      stage('Hello') {
                          steps {
                               sh " bash ../$jenkins_pipeline_name@libs/$jenkins_lib_name/jenkins-shared.sh"
           }
       }
  
   }
}
}

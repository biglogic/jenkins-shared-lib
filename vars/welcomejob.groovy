def call(String name = 'User') {
		echo "$name"
                pipeline {
                  agent any
                   stages {
                      stage('Setup parameters') {
                            steps {
                              script { 
                                 properties([
                                     parameters([
                                        string(
                                          defaultValue: 'Firstjob-with_shared_lib', 
                                          name: 'jenkins_pipeline_name', 
                                          trim: true
                                        ),
                                        string(
                                          defaultValue: 'first_jenkins_shared',
                                          name: 'jenkins_lib_name',
                                          trim: true
                                        ) 
                                   ])
                               ])
                           } 
                       }
                      }
                      stage('Hello') {
                          steps {
                               sh " bash ../$jenkins_pipeline_name@libs/$jenkins_lib_name/jenkins-shared.sh"
           }
       }
  
   }
}
}

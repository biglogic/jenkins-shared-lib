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
                                        )
                                   ])
                               ])
                           } 
                       }
                      stage('Hello') {
                          steps {
                               sh " bash ../Firstjob_with_shared_lib@libs/first_jenkins_shared/jenkins-shared.sh"
           }
       }
    }
}
}
}

def call(String name = 'User') {
		echo "$name"
                pipeline {
                  agent any
                   stages {
                     stage('Hello') {
                          steps {
                               sh " bash ../Firstjob_with_shared_lib@libs/first_jenkins_shared/jenkins-shared.sh"
           }
       }
    }
}

}

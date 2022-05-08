pipelineJob('job-dsl-artifactory-pipeline-example') {
    parameters {
        activeChoiceParam('CHOICE-1') {
            description('Allows user choose from multiple choices')
            filterable()
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('''
                    import groovy.json.JsonSlurper
                                try {
                                    def artifactsUrl = "http://10.0.0.204:8083/connectors/"          
                                    def artifactsObjectRaw = ["curl", "-s", "-H", "accept: application/json", "-k", "--url", "${artifactsUrl}"].execute().text
                                    def jsonSlurper = new JsonSlurper()
                                    def artifactsJsonObject = jsonSlurper.parseText(artifactsObjectRaw)
                                    def dataArray = artifactsJsonObject
                                    return dataArray
                                } catch (Exception e) {
                                    return [e]
                                }
                       
                 ''')
                fallbackScript('"fallback choice"')
            }
        }
    }
    definition {
        cps {
            script('''pipeline {
            agent any
                stages {
                    stage('Stage 1') {
                        steps {
                            echo 'logic'
                        }
                    }
                    stage('Stage 2') {
                        steps {
                            echo 'logic'
                        }
                    }
                }
            }
        }    ''')
            sandbox()
        }
    }
}

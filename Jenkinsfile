node {
    stage('Initialize') {
        def dockerHome = tool 'docker'
        def mavenHome = tool 'maven-3'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
        env.BUILD_TIME = sh(returnStdout: true, script: 'date +%F-%T').trim()
        env.WORKSPACE_LOCAL = sh(returnStdout: true, script: 'pwd').trim()
    }

    stage('Checkout') {
        checkout scm
    }

    stage('Build') {
        sh 'uname -a'
        sh 'mvn clean install'
    }

    stage('Expose report') {
        archive '**/cucumber.json'
        cucumber '**/cucumber.json'
    }

    stage('Import tasks to Jira for Features') {

        def xrayConnectorId = "335af8bd-b7bd-41d4-ab8a-cde00f41bbd1"
        step([$class        : 'XrayImportFeatureBuilder',
              folderPath    : 'target/test-classes/features',
              projectKey    : 'CAL',
              serverInstance: xrayConnectorId]
        )
    }

    stage('Import results to Xray') {

        def description = "[BUILD_URL|${env.BUILD_URL}]"
        def labels = '["end_to_end","automated_end_to_end"]'
        def environment = "DEV"
        def testExecutionFieldId = 10007
        def testEnvironmentFieldName = "customfield_10131"
        def projectKey = "CAL"
        def xrayConnectorId = "335af8bd-b7bd-41d4-ab8a-cde00f41bbd1"
        def info = '''{
				"fields": {
					"project": {
					"key": "''' + projectKey + '''"
				},
				"labels":''' + labels + ''',
				"description":"''' + description + '''",
				"summary": "Automated End to end Test Execution @ ''' + env.BUILD_TIME + ' ' + environment + ''' " ,
				"issuetype": {
				"id": "''' + testExecutionFieldId + '''"
				},
				"''' + testEnvironmentFieldName + '''" : [
				"''' + environment + '''"
				]
				}
				}'''
        echo info
        step([$class           : 'XrayImportBuilder',
              endpointName     : 'CUCUMBER_MULTIPART',
              importFilePath   : 'target/cucumber.json',
              importInfo       : info,
              inputInfoSwitcher: 'fileContent',
              serverInstance   : xrayConnectorId]
        )
    }
}

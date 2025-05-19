// Jenkinsfile (Declarative Pipeline) pour le projet Maven

pipeline {
    agent any

    tools {
        // Assurez-vous que 'Maven_3.9.x' correspond EXACTEMENT au nom configuré dans Jenkins -> Outils
        maven 'Maven_3.9.9'
        // Ajoutez un JDK si nécessaire
        // jdk 'AdoptOpenJDK-11'
    }

    stages {
        stage('Checkout') {
            steps {
                cleanWs()
                checkout scm
                echo 'Code source récupéré.'
            }
        }

        // Étape 2 : Construction avec Maven
        stage('Build') {
            steps {
                echo "Début du build Maven..."
                // Exécute Maven. 'mvn' est dans le PATH grâce à la directive 'tools'.
                // Adaptez les goals Maven (ex: 'clean install', 'clean package', 'verify')
                // Si pom.xml n'est pas à la racine: sh "mvn -f chemin/vers/pom.xml clean package"
                sh 'mvn clean package' // Ou 'bat "mvn clean package"' pour Windows
                echo 'Build Maven terminé.'
            }
        }

        // Étape 3 : Archivage des artefacts
        stage('Archive Artifacts') {
            steps {
                echo "Archivage des artefacts..."
                // Archive les fichiers produits par le build Maven (typiquement dans 'target/')
                // Adaptez le pattern si nécessaire (ex: 'target/*.war', '**/target/*.jar')
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                echo "Artefacts archivés."
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé.'
            // cleanWs()
        }
        success {
            echo 'Build réussi !'
        }
        failure {
            echo 'Build échoué !'
        }
    }
}

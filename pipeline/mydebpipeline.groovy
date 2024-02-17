pipeline {
    agent any

    stages {
        stage('Execute commands') {
            steps {
                script {
                    if (!fileExists('testdebian')) {
                        sh 'mkdir -p testdebian/DEBIAN testdebian/usr/local/bin'
                        sh 'wget https://github.com/Enot21/countfiles/archive/main.zip -O main.zip'
                        sh 'unzip main.zip'
                        sh 'mv system_programming-main/debian/control testdebian/DEBIAN'
                        sh 'mv system_programming-main/count_files.sh testdebian/usr/local/bin/'
                        sh 'dpkg-deb --build testdebian'
                    }
                }
            }
        }

        stage('Install Debian Package') {
            steps {
                script {
                    sh 'dpkg -i testdebian.deb'
                    sh 'chmod +x /usr/local/bin/count_files.sh'
                    sh 'count_files.sh --check_dir=system_programming-main'
                }
            }
        }
    }
}

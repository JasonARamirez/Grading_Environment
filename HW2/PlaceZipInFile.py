import os
import sys
import errno
import json
from zipfile import ZipFile
from shutil import copy2
from datetime import datetime
from FileManipulation import replaceStringsInFile

def makeDirectory(directory):
    try:
        if not os.path.exists(directory):
            os.makedirs(directory)
    except OSError as e:
        if e.errno != errno.EEXIST:
            raise

def extractAndCopyFiles(filename, zipFileDir, templateName, students):
    student = filename.replace('.zip', '')
    if student not in students:
        students[student] = 0
    else:
        students[student] += 1
        student += '_' + str(students[student])
    studentDir = zipFileDir + '_unzipped/' + student
    makeDirectory(studentDir)
    zip = ZipFile(zipFileDir + '/' + filename)
    zip.extractall(studentDir)
    copy2(templateName, studentDir + '/' + student + '.txt')

def setupGradingTemplateWithGraderAttributes(jsonFileName, templateName):
    toBeReplaced = list()
    replacors = list()
    with open(jsonFileName) as data_file:
        data = json.load(data_file)
        data_file.close()
        for key, value in data.items():
            toBeReplaced.append(key)
            replacors.append(value)

    replaceStringsInFile(templateName, toBeReplaced, replacors)

def main(assignment):
    students = {}
    zipFileDir = assignment + '_Submissions'
    templateName = assignment + 'GradingTemplate_' + str(datetime.now().year) + '.txt'

    setupGradingTemplateWithGraderAttributes("json_attributes/GraderAttributes.json", templateName)

    for file in os.listdir(os.fsencode(zipFileDir)):
        filename = os.fsdecode(file)
        if filename.endswith(".zip"):
            extractAndCopyFiles(filename, zipFileDir, templateName, students)
        else:
            makeDirectory('Errors')
            copy2(zipFileDir + '/' + filename, 'Errors/' + filename)

if __name__ == '__main__':
    if not len(sys.argv) == 2:
        print('Missing specific homework arguement')
    else:
        main(sys.argv[1])

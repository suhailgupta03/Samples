Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+FilePaths.fsPath)),"UTF-8"));
            Iterator i = fileList.iterator();
            while(i.hasNext()) {
                out.write(i.next().toString() + System.getProperty("line.separator"));
            }
            out.close();
package com.practice.svm;

import libsvm.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class Demo {
    static svm_parameter _param; //svm 參數
    static svm_problem _prob; //產生 svm 格式的檔案
    static String _model_file = ""; //model路徑
    //資料中最大的維度用來產生gamma參數
    static Vector answer ;
    static Vector svmFeatureVector;
    //feature 數量
    static int features = 3;
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassCastException, ClassNotFoundException {
        // default values
        _param = new svm_parameter();
        _param.svm_type = svm_parameter.C_SVC;
        //set type of kernel function
        _param.kernel_type = svm_parameter.RBF;
        //set degree in kernel function (default 3)
        _param.degree = 3;
        //set gamma in kernel function (default 1/num_features)
        //可以調整的RBF參數
        _param.gamma = 0;       // 1/num_features
        //set coef0 in kernel function (default 0)
        _param.coef0 = 0;
        //set the parameter nu of nu-SVC, one-class SVM, and nu-SVR (default 0.5)
        _param.nu = 0.5;
        //set cache memory size in MB (default 100)
        _param.cache_size = 100;

        //set the parameter C of C-SVC, epsilon-SVR, and nu-SVR (default 1)
        //penalty參數
        //_param.C = 1;
        //set tolerance of termination criterion (default 0.001)
        _param.eps = 1e-3;
        //set the epsilon in loss function of epsilon-SVR (default 0.1)
        _param.p = 0.1;
        //whether to use the shrinking heuristics, 0 or 1 (default 1)
        _param.shrinking = 1;
        //whether to train a SVC or SVR model for probability estimates, 0 or 1 (default 0)
        _param.probability = 1;//default是0, 要設為1才可以使用 svm_predict_probability
        _param.nr_weight = 0;
        _param.weight_label = new int[0];
        //_param.weight_label[0] = 1;
        //set the parameter C of class i to weight*C, only for C-SVC (default 1)
        _param.weight = new double[0];
        //_param.weight[0] = 1;
        //String str="Microsoft said in a statement: \"While the outcome is not what we had hoped for, we will continue to advocate for changes to the law that will prevent abuse of the patent system and protect inventors who hold patents representing true innovation.\"";
        //以上是參數設定，以下則是SVM的訓練與預測，並且找尋出Cost與Gamma的最佳參數
        for(int C=-15;C<=15;C++){
            for(int D=-15;D<=15;D++){
                double GMean = 0;
        //penalty參數
        _param.C = Math.pow(2, C);
        //if(_param.C==1)continue;
        _param.gamma=Math.pow(2, D);

        _prob = new svm_problem();
        answer = new Vector();
        svmFeatureVector = new Vector();
        //讀取訓練資料======================================================
        //正確答案的標籤
        //假設訓練的例子為:
        //文件1: 1 25 10 33 (1:代表分類為type 1;25,10,33代表文件一的三個屬性)
        double temp [] ={1,25,10,33};
        answer.addElement(temp[0]);
        //讀入訓練的資料
        svm_node[] x = new svm_node[features];
        int k=0;
        for(int j=1;j<temp.length;j++) {
            //新增一個SVM node，其中 index與value分別代表屬性在向量中的位置與數值
            x[k] = new svm_node();
            x[k].index = j;
            x[k].value = temp[j];
            k++;
        }
        svmFeatureVector.addElement(x);
        //==============================================================
        //svm node的數量
        _prob.l = answer.size();
        _prob.x = new svm_node[_prob.l][];
        for(int i=0;i<_prob.l;i++) _prob.x[i] = (svm_node[])svmFeatureVector.elementAt(i);   //儲存每個node的向量
        _prob.y = new double[_prob.l];
        for(int i=0;i<_prob.l;i++) _prob.y[i] = (double) answer.elementAt(i);    //儲存每個node的label
        //將此向量正規化, 因為每個屬性值是不能比較的, 必須正規化
        double sumValue1 [] = new double[features];
        double sumCount1 [] = new double[features];
        //對於每個instance
        for(int i=0;i<_prob.l;i++){
            //對於每一個node(node長度不一)
            for(int j=0;j<_prob.x[i].length;j++) {
                for(int value=1;value<=features;value++){
                    if(_prob.x[i][j].index==value){
                        sumValue1[value-1]+=_prob.x[i][j].value;
                        sumCount1[value-1]++;
                    }//end of for
                }
            }//end of for
        }
        //進行normalize
        for(int i=0;i<_prob.l;i++){
            //對於每一個node(node長度不一)
            for(int j=0;j<_prob.x[i].length;j++) {
                for(int value=1;value<=features;value++)//value代表vecctor的features長度{
                    if(_prob.x[i][j].index==value){
                        if(sumValue1[value-1]!=0) {
                            _prob.x[i][j].value/=sumValue1[value-1];
                        }else{
                            _prob.x[i][j].value=0;
                        }
                    }//end of if
            }
        }
    }
    //訓練程序==============================================
    //指定SVM model儲存的檔案名稱
    _model_file = "svm_model.txt";
    //訓練SVM model
    svm_model modelForTraining = svm.svm_train(_prob, _param);
    //將訓練結果寫入檔案
                svm.svm_save_model(_model_file, modelForTraining);
    //======================================================
    //read data for testing
    _prob = new svm_problem();
    answer = new Vector();
    svmFeatureVector = new Vector();
    //讀取資料======================================================
    //文件二 0 10 5 5
    double testingData [] = {0,10,5,5};
                answer.addElement(testingData[0]);
    //讀入訓練的資料
    svm_node [] y = new svm_node[features];
    int p=0;
                for(int j=1;j<testingData.length;j++){
        y[p] = new svm_node();
        y[p].index = j;
        y[p].value = testingData[j];
        p++;
    }
                svmFeatureVector.addElement(y);
    //讀取資料======================================================
    //svm node的數量
    _prob.l = answer.size();
    //儲存每個node的向量
    _prob.x = new svm_node[_prob.l][];
                for(int i=0;i<_prob.l;i++) _prob.x[i] = (svm_node[])svmFeatureVector.elementAt(i);
    //儲存每個node的label
    _prob.y = new double[_prob.l];
                for(int i=0;i<_prob.l;i++) _prob.y[i] = (double) answer.elementAt(i);
    //正規化
    double sumValue2 [] = new double[features];
    double sumCount2 [] = new double[features];
    //對於每個instance
                for(int i=0;i<_prob.l;i++){
        //對於每一個node(node長度不一)
        for(int j=0;j<_prob.x[i].length;j++){
            for(int value=1;value<=features;value++){
                if(_prob.x[i][j].index==value){
                    sumValue2[value-1]+=_prob.x[i][j].value;
                    sumCount2[value-1]++;
                }
            }
        }
    }
    //進行normalize
                 for(int i=0;i<_prob.l;i++){
        //對於每一個node(node長度不一)
        for(int j=0;j<_prob.x[i].length;j++){
            for(int value=1;value<=features;value++){
                if(_prob.x[i][j].index==value){
                    if(sumValue2[value-1]!=0){
                        _prob.x[i][j].value/=sumValue2[value-1];
                    }else{
                        _prob.x[i][j].value=0;
                    }
                }
            }
        }
    }
    //Testing==============================================
    svm_model modelForTesting;
    double tp_fn=0,tn_fp=0,tp=0,tn=0,fp=0,fn=0;
    modelForTesting = svm.svm_load_model(_model_file);  //載入model
                for(int i=0;i<_prob.l;i++){
        //對problem 裡的每個SVM node
        double v;
        svm_node[] testingNode = _prob.x[i];    //取出svm node
        v = svm.svm_predict(modelForTesting, testingNode);  //把node餵給預測器
        //這時預測器會依照model與node內的向量資訊，產生預測的數值(-1或1)
        //tp,tn,fp,fn產生 (在此我們把 document 具有競爭意涵當成 positive class)
        if(v==1)tp_fn++;
        if(v==0)tn_fp++;
        if(v == _prob.y[i]&&v==1)tp++;
        if(v == _prob.y[i]&&v==0)tn++;
    }
    double tpr = 0;
    double tnr = 0;
    fn=tp_fn-tp;
    fp=tn_fp-tn;
                System.out.println("True positive = "+tp);
                System.out.println("Positive class: "+tp_fn);
                if(tp_fn==0){
        System.out.println("True positive rate = "+0);
        tpr=0;
    }else{
        System.out.println("True positive rate = "+tp/tp_fn);
        tpr=(tp/tp_fn);
    }
                System.out.println("False positive = "+fp);
                System.out.println("False positive rate = "+(fp/tn+fp));
                System.out.println("True negative = "+tn);
                System.out.println("Negative class: "+tn_fp);
                if((tn_fp)==0){
        System.out.println("True negative rate = "+0);
        tnr=0;
    }else{
        System.out.println("True negative rate = "+tn/tn_fp);
        tnr=(tn/tn_fp);
    }
                System.out.println("False negative = "+(fn));
                if((tp+fn)==0){
        System.out.println("False negative rate = "+0);
    }else{
        System.out.println("False negative rate = "+fn/(tp+fn));
    }
    double precision=(tp/(tp+fp));
    double recall = 0;
                if((tp+fn)==0){
        recall = 0;
    }else{
        recall =(tp/(tp+fn));
    }
    double fscore = 0;
                if((precision+recall)==0){
        fscore = 0;
    }else{
        fscore=(2*precision*recall)/(precision+recall);
    }
                System.out.println("Precision = "+precision);
                System.out.println("Recall = "+recall);
                System.out.println("Precision = "+fscore);
}//end of parameter gamma
        }//end of parameter C
                }


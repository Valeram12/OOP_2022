using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Finish : MonoBehaviour
{
    public GameObject text;
    public GameObject button;

    public int score=0;
    void Start(){
        if(PlayerPrefs.HasKey("score")){score = PlayerPrefs.GetInt("score");}else{score=0;}
    }

    private void OnTriggerEnter(){
    score+=1;
    PlayerPrefs.SetInt("score",score);
    PlayerPrefs.Save();

    text.SetActive(true);
    button.SetActive(true);
    Time.timeScale = 0;

    }
}

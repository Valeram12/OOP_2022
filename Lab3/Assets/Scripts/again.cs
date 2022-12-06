using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
public class again : MonoBehaviour
{

    public GameObject text;
    public GameObject button;
    public void onClick()
    {
        SceneManager.LoadScene("SampleScene");
         text.SetActive(false);
         button.SetActive(false);
         Time.timeScale = 1;

    }

}

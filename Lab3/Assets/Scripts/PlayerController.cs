using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
public float speed = 7f;
public Joystick joy;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
    if (joy.Horizontal>=0.2f)
    {
        transform.localPosition+=transform.right*speed*Time.deltaTime;
    }
    if (joy.Horizontal<=-0.2f)
    {
        transform.localPosition+=-transform.right*speed*Time.deltaTime;
    }
     if (joy.Vertical>=0.2f)
        {
            transform.localPosition+=transform.forward*speed*Time.deltaTime;
        }
        if (joy.Vertical<=-0.2f)
        {
            transform.localPosition+=-transform.forward*speed*Time.deltaTime;
        }
        
    }
}

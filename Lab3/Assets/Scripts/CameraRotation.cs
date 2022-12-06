using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraRotation : MonoBehaviour
{
private float joyX;
private float joyY;
public Joystick joy;
 public Transform player;
    public float mouseSensitivity = 2f;
    float cameraVerticalRotation = 0f;

    bool lockedCursor = true;

    void Update()
    {
        // Collect Mouse Input

        float joyX = joy.Horizontal*mouseSensitivity;
        float joyY = joy.Vertical*mouseSensitivity;

        // Rotate the Camera around its local X axis

        cameraVerticalRotation -= joyY;
        cameraVerticalRotation = Mathf.Clamp(cameraVerticalRotation, -90f, 90f);
        transform.localEulerAngles = Vector3.right * cameraVerticalRotation;


        // Rotate the Player Object and the Camera around its Y axis

        player.Rotate(Vector3.up * joyX);

    }
}

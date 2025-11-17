using System.Collections;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.SceneManagement;

public class WallCtrl : MonoBehaviour
{
    public float speed;
    private Renderer[] cubeRenderer;
    Color ColorBySpeed;


    private void Awake()
    {
        cubeRenderer = GetComponentsInChildren<Renderer>();
    }

    private void Start()
    {

        int random_Speed = Random.Range(-6, -3);


        switch (random_Speed)
        {
            case -6:
                ColorBySpeed = Color.red;
                break;
            case -5:
                ColorBySpeed = Color.green;
                break;
            case -4:
                ColorBySpeed = Color.blue;
                break;
        }

        foreach (Renderer rend in cubeRenderer)
        {

            rend.material.color = ColorBySpeed;
        }

        speed = random_Speed;

        Destroy(this.gameObject, 5.0f);
    }
        void Update()
        {
            this.transform.Translate(speed * Time.deltaTime, 0, 0);
        }

}
